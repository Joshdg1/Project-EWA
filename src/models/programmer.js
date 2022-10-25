class Programmer {
    firstname;
    lastname;
    address;
    city;
    knowledge;
    experience;
    availability;
    hours;
    workPreference;
    projectType;

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
     * @param workPreference
     * @param projectType
     */
    constructor(firstname, lastname, address, city, knowledge, experience, availability, hours, workPreference, projectType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.knowledge = knowledge;
        this.experience = experience;
        this.availability = availability;
        this.hours = hours;
        this.workPreference = workPreference;
        this.projectType = projectType;
    }

    static createProgrammer(){
        let randomNameNumber = Math.floor(Math.random() * 5);
        let randomAddressNumber = Math.floor(Math.random() * 3);
        let randomExperience = Math.floor(Math.random() * 2);

        return new Programmer(fakeFirstname[randomNameNumber], fakeLastname[randomNameNumber], fakeAddress[randomAddressNumber],
        fakeCity[randomNameNumber], fakeKnowledge[randomNameNumber], fakeExperience[randomExperience],
            fakeAvailability[randomExperience], fakeHours[randomNameNumber], fakeWorkPreference[randomExperience],
            fakeProjectType[randomAddressNumber]);
    }

}


const fakeFirstname = ["Henk", "Piet", "Esra", "Lars", "Mees"];
const fakeLastname = ["Steen", "de Lange", "Pietersma", "Groot", "Schagen"];
const fakeAddress = ["De bouwstraat 8", "Wibautstraat", "platstraat"];
const fakeCity = ["Amsterdam", "Zaandam", "Hoorn", "Den Haag", "Volendam"];
const fakeKnowledge = ["PHP", "C#", "HTML", "CSS", "JAVA"];
const fakeExperience = ["Ik heb nog geen ervaring.", "IK heb al bij 3 andere software bedrijven gewerkt als software engineer."];
const fakeAvailability = ["7 dagen in de week", "5 dagen in de week."];
const fakeHours = ["12", "20", "30", "36", "40"];
const fakeWorkPreference = ["Thuis", "Op kantoor"];
const fakeProjectType = ["Frontend", "Backend", "Fullstack"];

export default Programmer;