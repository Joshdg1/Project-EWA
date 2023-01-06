import API from "../scripts/API";

export default class ProjectRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/projects/';
    }

    async getAllProjects() {
        return await API.get(this.url);
    }

    async createProject(name, description, client_id, start_date, end_date, programmer_ids) {
        return await API.post(
            this.url + "add",
            {
                name, description, client_id, start_date, end_date, programmer_ids
            }
        );
    }

    async updateProjectById(projectId, title, description, company, startDate, endDate, programmers) {
        return await API.put(
            this.url + projectId,
            {
                projectId, title, description, company, startDate, endDate, programmers
            }
        );
    }

    async deleteProjectById(projectId){
        return await API.delete(this.url + projectId);
    }
}