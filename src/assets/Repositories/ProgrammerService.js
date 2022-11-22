
export default class ProgrammerRepository {
    async findProgrammerById(programmerId){
        const response = await fetch("http://localhost:8081/programmers/" + programmerId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllProgrammers() {
        const response = await fetch('http://localhost:8081/programmers');
        return await response.json();
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
                                availability, workPreference, projectType, skills)
    {
        const response = await fetch('http://localhost:8081/programmers/' + programmerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({programmerId,firstName, lastName, email, address, city,
                postcode, availability, workPreference, projectType, skills}),
        });
        return await response.json();
    }



}