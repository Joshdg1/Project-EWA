import API from "../scripts/API";

export default class SkillRepository {
    async findSkillsByUserId(userId){
        return await API.get(`/skills/${userId}`);
    }

    async createSkill (skillName, skillLevel, userId) {
        return await API.post(
            `/skills/add`,
            {
                skillName, skillLevel, userId
            }
        );
    }

    async deleteSkillById(skillsId){
        return await API.delete(`/users/${skillsId}`);
    }
}