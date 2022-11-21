
export default class ProgrammerRepository {
    async getProgrammerById() {
        const response = await fetch('http://localhost:8080/programmers/0');
        return await response.json();
    }
    

    async updateProgrammer(title, description, company, hoursWorked, programmers) {
        const response = await fetch('http://localhost:8080/programmers/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title, description, company, hoursWorked, programmers
            }),
        });
        return await response.json();
    }


}