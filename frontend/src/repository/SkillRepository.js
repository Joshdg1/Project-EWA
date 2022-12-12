export default class SkillRepository {
    async findSkillsById(skillsId){
        const response = await fetch("http://localhost:8081/skills/" + skillsId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllSkills() {
        const response = await fetch('http://localhost:8081/skills');
        return await response.json();
    }


    // async createSkill (id, name, level) {
    //     const response = await fetch('http://localhost:8081/skills/add', {
    //         method: 'POST',
    //         headers: {
    //             'Content-Type': 'application/json',
    //         },
    //         body: JSON.stringify({
    //            id, name, level,
    //         }),
    //     });
    //     return await response.json();
    // }
    async deleteSkillsById(skillsId){
        const response = await fetch('http://localhost:8081/programmers/' + skillsId, {
            method: 'DELETE',
        });
        return await response.json();
    }
    async  updateProgrammerById(programmerId,firstName, lastName, email,address, city, postcode,
                                availability, workPreference, projectType,)
    {
        const response = await fetch('http://localhost:8081/programmers/' + programmerId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({programmerId,firstName, lastName, email, address, city,
                postcode ,projectType, workPreference,availability}),
        });
        return await response.json();
    }



}