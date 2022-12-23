import API from "../scripts/API";

export default class UserRepository {

    async findProgrammerById(userId) {
        return await API.get(`/users/${userId}`);
    }

    async getAllUsers() {
        return await API.get(`/users`);
    }

    async getAllProgrammers() {
        return await API.get(`/users/programmers`);
    }

    async getAllClients() {
        return await API.get(`/users/clients`);
    }

    async loginUser(email, password) {
        return await API.post(
            `/users/login`,
            {
                email, password
            }
        );
    }

    async createUser(email, firstName, lastName, password, phoneNumber, userType) {
        return await API.post(
            `/users/add`,
            {
                email, firstName, lastName, password, phoneNumber, userType
            }
        );
    }

    async updateUserById(userId, email, firstName, lastName, phoneNumber, userType) {
        return await API.put(
            `/users/${userId}`,
            {
                userId, email, firstName, lastName, phoneNumber, userType
            }
        );
    }

    async deleteUserById(userId) {
        return await API.delete(`/users/${userId}`);
    }
}