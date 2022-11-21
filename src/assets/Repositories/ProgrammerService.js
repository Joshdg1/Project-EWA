
export default class ProgrammerRepository {
    async getAllProjects() {
        const response = await fetch('http://localhost:8080/programmers');
        return await response.json();
    }

    // async createProject(title, description, company, hoursWorked, programmers) {
    //     const response = await fetch('http://localhost:8080/programmers/add', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify({
    //             title, description, company, hoursWorked, programmers
    //         }),
    //     });
    //     return await response.json();
    // }


}