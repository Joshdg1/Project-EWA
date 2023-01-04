import API from "../scripts/API";

export default class ProjectRepository {

    async getAllProjects() {
        return await API.get(`/projects`);
    }

    async createProject(name, description, client_id, start_date, end_date, programmer_ids) {
        return await API.post(
            `/projects/add`,
            {
                name, description, client_id, start_date, end_date, programmer_ids
            }
        );
    }

    async updateProjectById(projectId, title, description, company, startDate, endDate, programmers) {
        return await API.put(
            `/projects/${projectId}`,
            {
                projectId, title, description, company, startDate, endDate, programmers
            }
        );
    }

    async deleteProjectById(projectId){
        return await API.delete(`/projects/${projectId}`);
    }
}