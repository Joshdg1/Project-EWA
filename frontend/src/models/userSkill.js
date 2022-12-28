export class UserSkill{
    programmerId;
    skillId
    skillName;
    skillLevel;

    constructor(programmerId, skillId, skillName, skillLevel) {
        this.programmerId = programmerId;
        this.skillId = skillId
        this.skillName = skillName;
        this.skillLevel = skillLevel;
    }
}