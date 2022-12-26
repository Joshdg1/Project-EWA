import API from "../scripts/API";

export default class AvailabilityRepository {

    async getAvailabilityById(id) {
        return await API.get(`/availability/${id}`);
    }

    async createAvailability(title, startDate, endDate , userId) {
        return await API.post(
            `/availability/add`,
            {
                title, startDate, endDate , userId
            }
        );
    }

    async deleteAvailability(Id) {
        return await API.delete(`/availability/${Id}`);
    }

    async updateAvailabilityById(Id,title,startDate, endDate, userId ) {
        return await API.put(
            `/availability/${Id}`,
            {
                title, startDate, endDate , userId
            }
        );
    }

}