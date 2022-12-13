export default class ProjectRepository {
    async getAllProjects() {
        const response = await fetch('http://localhost:8081/projects');
        return await response.json();
    }
    async getAllProjectsByUser(id){
        const response = await fetch('http://localhost:8081/projects' + id, {
            method: "GET"
        });
        return await response.json();
    }

    async createProject(title, description, company, startDate, endDate, programmers) {
        const response = await fetch('http://localhost:8081/projects/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                title, description, company, startDate, endDate, programmers
            }),
        });
        return await response.json();
    }

    async deleteProjectById(projectId){
        const response = await fetch('http://localhost:8081/projects/' + projectId, {
            method: 'DELETE',
        });
        return await response.json();
    }

    async updateProjectById(projectId, title, description, company, hoursWorked, programmers) {
        const response = await fetch('http://localhost:8081/projects/' + projectId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({projectId, title, description, company, hoursWorked, programmers}),
        });
        return await response.json();
    }


}