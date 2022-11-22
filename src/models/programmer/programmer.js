class Programmer {
    id
    firstName;
    lastName;
    email;
    address;
    city;
    postcode;
    availability;
    workPreference;
    projectType;
    skills;


    constructor(id, firstName, lastName, email, address, city, postcode, availability, workPreference, projectType, skills) {
        this.id = id
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.availability = availability;
        this.workPreference = workPreference;
        this.projectType = projectType;
        this.skills = skills;
    }

    static copyConstructor(programmer) {
        if (programmer === null) return null;
        return Object.assign(new Programmer(0), programmer)
    }
}




export default Programmer;



