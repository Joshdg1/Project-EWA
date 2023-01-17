import User from "./user.js";


const PROFILE_ID = 8;
const PROFILE_FIRSTNAME = "John";
const PROFILE_LASTNAME = "Do";
const PROFILE_EMAIL = "johndo@gmail.com";
const PROFILE_FILE = 'CV.png';
const PROFILE_PHONENUMBER = 123456789;

let user, user1

beforeEach(function () {
 user = new User(PROFILE_ID,PROFILE_FIRSTNAME,PROFILE_LASTNAME,PROFILE_EMAIL,PROFILE_FILE,PROFILE_PHONENUMBER)
    user1 = User.copyConstructor(user)
})

it('should Check if creating a user object is possible', function () {

    // checking if the copy constructor works
    expect(user1.id).toBe(8);
    expect(user1.firstName).toBe("John")
    expect(user1.lastName).toBe("Do")
    expect(user1.email).toBe("johndo@gmail.com")
    expect(user1.file).toBe('CV.png')
    expect(user1.phoneNumber).toBe(123456789)

    // checking if both objects are users
    expect(user).toBeInstanceOf(User)
    expect(user1).toBeInstanceOf(User)

});

