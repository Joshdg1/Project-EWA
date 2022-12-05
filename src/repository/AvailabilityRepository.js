

export default class AvailabilityRepository {
    async getAvailabilityById(id) {
        const response = await fetch('http://localhost:8081/availability/' + id , {
            method: "GET"
        });
        return await response.json();
    }

    async createAvailability(id, startDate, endDate) {
        const response = await fetch('http://localhost:8081/availability/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                id, startDate, endDate
            }),
        });
        return await response.json();
    }

    async deleteAvailability(Id) {
        const response = await fetch('http://localhost:8081/availability/' + Id, {
            method: 'DELETE',
        });
        return await response.json();
    }

    async updateAvailabilityById(clientId) {
        const response = await fetch('http://localhost:8081/availability/' + clientId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({}),
        });
        return await response.json();
    }


}