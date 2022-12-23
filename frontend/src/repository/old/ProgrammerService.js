// DEPRECIATED
export default class ProgrammerRepository {
    async findProgrammerById(programmerId){
        return await API.get(`/programmers/${programmerId}`);
    }

    async getAllProgrammers() {
        return await API.get(`/programmers`);
    }

    async createProgrammers (firstname, lastname, email, address, city, postcode, availability, workPreference, projectType,skills) {
        const response = await fetch('http://localhost:8081/programmers/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                firstname, lastname, email, address, city, postcode, availability, workPreference, projectType,skills
            }),
        });
        return await response.json();
    }

    async deleteProgrammerById(programmerId){
        const response = await fetch('http://localhost:8081/programmers/' + programmerId, {
            method: 'DELETE',
        });
        return await response.json();
    }
    async  updateProgrammerById(programmerId,firstName, lastName, email,address, city, postcode,
                                availability, workPreference, projectType,)
    {
        const response = await fetch('http://localhost:8081/programmers/' + programmerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({programmerId,firstName, lastName, email, address, city,
                postcode ,projectType, workPreference,availability}),
        });
        return await response.json();
    }



}