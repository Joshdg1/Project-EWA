class User {
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

    static copyConstructor(programmer) {
        if (programmer === null) return null;
        return Object.assign(new User(0), programmer)
    }
}

export default User;



