export default class ClientRepository {
    async getAllClients() {
        const response = await fetch('http://localhost:8080/clients');
        return await response.json();
    }

    async createClient(name, email, address, city, postcode, projectType) {
        const response = await fetch('http://localhost:8080/clients/add', {
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
        const response = await fetch('http://localhost:8080/clients/' + clientId, {
            method: 'DELETE',
        });
        return await response.json();
    }

    async updateClientById(clientId, name, email, address, city, postcode, projectType) {
        const response = await fetch('http://localhost:8080/clients/' + clientId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({name, email, address, city, postcode, projectType}),
        });
        return await response.json();
    }


}