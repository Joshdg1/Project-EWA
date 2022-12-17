export default class SkillRepository {
    async findSkillsById(userId){
        const response = await fetch("http://localhost:8081/skills/" + userId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllSkills(userId) {
        const response = await fetch('http://localhost:8081/skills/' + userId);
        return await response.json();
    }


    async createSkill (skillName, skillLevel, userId) {
        const response = await fetch('http://localhost:8081/skills/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                skillName, skillLevel, userId
            }),
        });
        return await response.json();
    }
    async deleteSkillsById(skillsId){
        const response = await fetch('http://localhost:8081/programmers/' + skillsId, {
            method: 'DELETE',
        });
        return await response.json();
    }
    async  updateProgrammerSkillById(programmerId, skillId, level)
    {
        const response = await fetch('http://localhost:8081/programmers/' + programmerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({programmerId, skillId, level}),
        });
        return await response.json();
    }



}