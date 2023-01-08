import API from "../scripts/API";

export default class UserRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/users/';
    }


    // todo use USER model in this file

    async findUserById(userId) {
        return await API.get(this.url + userId);
    }

    async getAllUsers() {
        return await API.get(this.url);
    }

    async getAllProgrammers() {
        return await API.get(this.url + "programmers");
    }

    async getAllClients() {
        return await API.get(this.url + "clients");
    }

    async loginUser(email, password) {
        return await API.post(
            this.url + "login",
            {
                email, password
            }
        );
    }

    async createUser(email, firstName, lastName, password, phoneNumber, userType) {
        return await API.post(
            this.url + "add",
            {
                email, firstName, lastName, password, phoneNumber, userType
            }
        );
    }

    async updateUserById(userId, email, firstName, lastName, phoneNumber, userType) {
        return await API.put(
            this.url + userId,
            {
                userId, email, firstName, lastName, phoneNumber, userType
            }
        );
    }



    async deleteUserById(userId) {
        return await API.delete(this.url + userId);
    }


    //body: JSON.stringify({
    //     title:name,
    //     body:body,
    //
    //   }),

    async sendEmail(email) {
        return await API.post(
            `/users/forgotPassword`,
            {
               email: email
            }
        );
    }
}