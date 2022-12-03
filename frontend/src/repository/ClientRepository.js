export default class ClientRepository {

    url;

    constructor() {
        /* eslint-disable */
        this.url = process.env.VUE_APP_API_URL + '/clients/';
    }


    async getAllClients() {
        const response = await fetch(this.url);
        return await response.json();
    }

    async createClient(name, email, address, city, postcode, projectType) {
        const response = await fetch(this.url + 'add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                name, email, address, city, postcode, projectType
            }),
        });
        return await response.json();
    }

    async deleteClientById(clientId) {
        const response = await fetch(this.url + clientId, {
            method: 'DELETE',
        });
        return await response.json();
    }

    async updateClientById(clientId, name, email, address, city, postcode, projectType, projects) {
        const response = await fetch(this.url + clientId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, email, address, city, postcode, projectType, projects}),
        });
        return await response.json();
    }


}