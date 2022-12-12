export default class AvailabilityRepository {

    async findAllAvailibilitys(){
        const response = await fetch('http://localhost:8081/availability/', {
            method: "GET"
        });
        return await response.json();
    }
    async getAvailabilityById(id) {
        const response = await fetch('http://localhost:8081/availability/' + id , {
            method: "GET"
        });
        return await response.json();
    }

    async createAvailability(startDate, endDate , userId) {
        const response = await fetch('http://localhost:8081/availability/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                 startDate, endDate , userId
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

    async updateAvailabilityById(Id,startDate, endDate, userID ) {
        const response = await fetch('http://localhost:8081/availability/',  + Id, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                startDate, endDate , userID
            }),
        });
        return await response.json();
    }


}