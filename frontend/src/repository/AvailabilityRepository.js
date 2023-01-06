import API from "../scripts/API";

export default class AvailabilityRepository {

    async getAvailabilityById(id) {
        return await API.get(`/availability/${id}`);
    }

    async createAvailability(project, startDate, endDate , userId) {
        return await API.post(
            `/availability/add`,
            {
                project, startDate, endDate , userId
            }
        );
    }

    async deleteAvailability(Id) {
        return await API.delete(`/availability/${Id}`);
    }

    async updateAvailabilityById(Id,project,startDate, endDate, userId ) {
        return await API.put(
            `/availability/${Id}`,
            {
                project, startDate, endDate , userId
            }
        );
    }

}