export class Programmer {
    firstname;
    lastname;
    address;
    city;
    knowledge;
    experience;
    availability;
    hours;
    workPreference;
    projectTypes;

    /**
     * Constructor
     *
     * @param id
     * @param firstname
     * @param lastname
     * @param email
     * @param address
     * @param city
     * @param knowledge
     * @param experience
     * @param availability
     * @param hours
     * @param workPreference
     * @param projectTypes
     */
    constructor(id ,firstname, lastname, email, address, city, knowledge, experience, availability, hours, workPreference, projectTypes) {
        this.id = id
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email
        this.address = address;
        this.city = city;
        this.knowledge = knowledge;
        this.experience = experience;
        this.availability = availability;
        this.hours = hours;
        this.workPreference = workPreference;
        this.projectTypes = projectTypes;
    }
    static copyConstructor(programmer) {
        if (programmer === null) return null;
        let copy =  Object.assign(new Programmer(0), programmer)
        copy.city = programmer.city
        return copy
    }
}