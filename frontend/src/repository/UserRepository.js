export default class UserRepository {

    url;

    constructor() {
        /* eslint-disable */
        this.url = process.env.VUE_APP_API_URL + '/users/';
    }

    async findProgrammerById(userId) {
        const response = await fetch(this.url + userId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllUsers() {
        const response = await fetch(this.url);
        return await response.json();
    }

    async getAllProgrammers() {
        const response = await fetch(this.url + "programmers");
        return await response.json();
    }

    async getAllClients() {
        const response = await fetch(this.url + "clients");
        return await response.json();
    }

    async createUser(email, firstName, lastName, password, phoneNumber, userType) {
        const response = await fetch(this.url + 'add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email, firstName, lastName, password, phoneNumber, userType
            }),
        });
        return await response.json();
    }

    async deleteUserById(userId) {
        const response = await fetch(this.url + userId, {
            method: 'DELETE',
        });
        return await response.json();
    }

    async updateUserById(userId, email, firstName, lastName, phoneNumber, userType) {
        const response = await fetch(this.url + userId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({userId, email, firstName, lastName, phoneNumber, userType}),
        });
        return await response.json();
    }

    async loginUser(email, password) {
        const response = await fetch(this.url + 'login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email, password
            }),
        });
        return await response.json();
    }

}