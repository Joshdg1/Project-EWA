import API from "../scripts/API";

export default class HourRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/hours/';
    }

    async getHoursById(id) {
        return await API.get(this.url + id);
    }

    async getHoursByProject(project){
        return await API.get(this.url +"project=" +  project.id)
    }

    async createHours(project, hours , userID) {
        return await API.post(
            this.url + "add",
            {
                project, hours , userID
            }
        );
    }

    async deleteHours(Id) {
        return await API.delete(this.url + Id);
    }

    async updateHoursById(Id,project,hours, userID, isApproved ) {
        return await API.put(
            this.url + Id,
            {
                project, hours, userID,isApproved
            }
        );
    }

}