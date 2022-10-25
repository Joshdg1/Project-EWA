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
    constructor(firstname, lastname, address, city, knowledge, experience, availability, hours, workPreference, projectTypes) {
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

    static createProgrammers() {
        let randomNameNumber = Math.floor(Math.random() * 6);
        let randomAddressNumber = Math.floor(Math.random() * 4);

        return new Programmer(fakeFirstname[randomNameNumber], fakeLastname[randomNameNumber])
        );
    }

}

const fakeFirstname = ["Henk", "Piet", "Esra", "Lars", "Mees"];
const fakeLastname = ["Steen", "de Lange", "Pietersma", "Groot", "Schagen"];
const fakeAddress = ["De bouwstraat 8", "Wibautstraat", "platstraat"];
const fakeCity = ["Amsterdam", "Zaandam", "Hoorn", "Den Haag", "Volendam"];
const fakeKnowledge = ["PHP", "C#", "HTML", "CSS", "JS", "JAVA"];
const fakeExperience = ["Ik heb nog geen ervaring.", "IK heb al bij 3 andere software bedrijven gewerkt als software engineer."];
const fakeAvailability = ["7 dagen in de week", "5 dagen in de week."];
const fakeHours = ["12", "20", "30", "36", "40"];
const fakeWorkPreference = ["Thuis", "Op kantoor"];
const fakeProjectTypes = ["Frontend", "Backend", "Fullstack"];


}