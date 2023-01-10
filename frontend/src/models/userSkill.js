export class UserSkill{
    id;
    level
    name;
    user_id;

    constructor(id, level, name, user_id) {
        this.id = id
        this.level = level;
        this.name = name;
        this.user_id = user_id;
    }
}