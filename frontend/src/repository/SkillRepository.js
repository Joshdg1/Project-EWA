import API from "../scripts/API";

export default class SkillRepository {
    url;   // the URL of the endpoint
    constructor() {
        // eslint-disable-next-line no-undef
        this.url = process.env.VUE_APP_API_URL + '/skills/';
    }
    async findSkillsByUserId(userId){
        return await API.get(this.url + userId);
    }

    async createSkill (skillName, skillLevel, userId) {
        return await API.post(
            this.url + "add",
            {
                skillName, skillLevel, userId
            }
        );
    }

    async getAllSkills(){
        return await API.get(
            this.url
        );
    }
    async deleteSkillById(skillsId){
        return await API.delete(this.url + skillsId);
    }
}