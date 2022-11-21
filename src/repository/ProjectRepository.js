export default class ProjectRepository {
    async getAllProjects() {
        const response = await fetch('http://localhost:8080/projects');
        return await response.json();
    }

    async createProject(title, description, company, hoursWorked, programmers) {
        const response = await fetch('http://localhost:8080/projects/add', {
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