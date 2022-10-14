class Programmer {
    firstname;
    lastname;
    address;
    city;
    knowledge;
    experience;
    availability;
    hours;
    workspace;
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
    constructor(firstname, lastname, address, city, knowledge, experience, availability, hours, workspace, projectTypes) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.knowledge = knowledge;
        this.experience = experience;
        this.availability = availability;
        this.hours = hours;
        this.workspace = workspace;
        this.projectTypes = projectTypes;
    }
}