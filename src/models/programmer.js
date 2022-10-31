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
     * @param firstname
     * @param lastname
     * @param address
     * @param city
     * @param knowledge
     * @param experience
     * @param availability
     * @param hours
     * @param workspace
     * @param projectTypes
     */
    constructor(id ,firstname, lastname, address, city, knowledge, experience, availability, hours, workPreference, projectTypes) {
        this.id = id
        this.firstname = firstname;
        this.lastname = lastname;
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