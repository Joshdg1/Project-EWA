import API from "../scripts/API";

export default class SkillRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/skills/';
    }

    async findSkillsById(userId){
        return await API.get(this.url + userId);
    }

    async getAllSkills(){
        return await API.get(
            this.url
        );
    }

    async createSkill (UserSkill) {
        return await API.post(
            this.url + "add",
            {
                ...UserSkill
            }
        );
    }

    async updateSkill (UserSkill) {
        console.log('UpdateSKill', UserSkill);
        return await API.put(
            this.url + UserSkill.id,
            {
               ...UserSkill
            }
        );
    }


    async deleteSkillById(skillsId){
        return await API.delete(this.url + skillsId);
    }
}