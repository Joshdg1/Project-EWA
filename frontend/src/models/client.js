class Client {
    name;
    email;
    address;
    city;
    postcode;
    projectType;

    /**
     *Constructor
     *
     * @param firstname
     * @param lastname
     * @param address
     * @param city
     * @param postcode
     */
    constructor(name, email, address, city, postcode, projectType) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.city = city;
        this.postcode = postcode;
        this.projectType = projectType;
    }

    static createClient(){
        let randomNameNumber = Math.floor(Math.random() * 5);
        let randomAddressNumber = Math.floor(Math.random() * 3);
        let randomFakeEmailNumber = Math.floor(Math.random() * 3);

        return new Client(name[randomNameNumber], fakeEmail[randomFakeEmailNumber], fakeAddress[randomAddressNumber],
            fakeCity[randomNameNumber],fakePostCode[randomNameNumber], fakeProjectType[randomAddressNumber]);
    }

}

const name = ["Henk", "Piet", "Esra", "Lars", "Mees"];
const fakeEmail = ["emailnep@lol.nl", "emailnep@lol.com", "emailnep@xdxd.com"];
const fakeAddress = ["De bouwstraat 8", "Wibautstraat", "platstraat"];
const fakeCity = ["Amsterdam", "Zaandam", "Hoorn", "Den Haag", "Volendam"];
const fakePostCode = ["1938HT", "1093LO", "3801EN", "0931DA", "1834TT"];
const fakeProjectType = ["Frontend", "Backend", "Fullstack"];

export default Client;