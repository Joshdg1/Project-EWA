import API from "../scripts/API";

export default class AvailabilityRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/availability/';
    }

    async getAvailabilityById(id) {
        return await API.get(this.url + id);
    }

    async createAvailability(project, startDate, endDate , userId) {
        return await API.post(
            this.url + "add",
            {
                project, startDate, endDate , userId
            }
        );
    }

    async deleteAvailability(Id) {
        return await API.delete(this.url + Id);
    }

    async updateAvailabilityById(Id,project,startDate, endDate, userId ) {
        return await API.put(
            this.url + Id,
            {
                project, startDate, endDate , userId
            }
        );
    }

}