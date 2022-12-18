class Programmer {
    id;
    firstName;
    lastName;
    email;
    file;
    phoneNumber;


    constructor(id, firstName, lastName, email, file, phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.file = file;
        this.phoneNumber = phoneNumber;
    }

    static createProgrammer(){
        let randomNameNumber = Math.floor(Math.random() * 5);
        let randomAddressNumber = Math.floor(Math.random() * 3);
        let randomExperience = Math.floor(Math.random() * 2);

        return new Programmer(fakeFirstname[randomNameNumber], fakeLastname[randomNameNumber], fakeAddress[randomAddressNumber],
            fakeCity[randomNameNumber], fakePostCode[randomNameNumber], fakeKnowledge[randomNameNumber], fakeExperience[randomExperience],
            fakeAvailability[randomExperience], fakeHours[randomNameNumber], fakeWorkPreference[randomExperience],
            fakeProjectType[randomAddressNumber]);
    }

    static copyConstructor(programmer) {
        if (programmer === null) return null;
        return Object.assign(new Programmer(0), programmer)
    }
}


const fakeFirstname = ["Henk", "Piet", "Esra", "Lars", "Mees"];
const fakeLastname = ["Steen", "de Lange", "Pietersma", "Groot", "Schagen"];
const fakeAddress = ["De bouwstraat 8", "Wibautstraat", "platstraat"];
const fakeCity = ["Amsterdam", "Zaandam", "Hoorn", "Den Haag", "Volendam"];
const fakePostCode = ["1938HT", "1093LO", "3801EN", "0931DA", "1834TT"];
const fakeKnowledge = ["PHP", "C#", "HTML", "CSS", "JAVA"];
const fakeExperience = ["Ik heb nog geen ervaring.", "Ik heb al bij 3 andere software bedrijven gewerkt als software engineer."];
const fakeAvailability = ["7 dagen in de week", "5 dagen in de week."];
const fakeHours = ["12", "20", "30", "36", "40"];
const fakeWorkPreference = ["Thuis", "Op kantoor"];
const fakeProjectType = ["Frontend", "Backend", "Fullstack"];

export default Programmer;



