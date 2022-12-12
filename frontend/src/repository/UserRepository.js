
export default class UserRepository {
    async findProgrammerById(userId){
        const response = await fetch("http://localhost:8081/users/" + userId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllProgrammers() {
        const response = await fetch('http://localhost:8081/users');
        return await response.json();
    }


    async createProgrammers (  email,  firstName,  lastName,  password,  phoneNumber,  userType) {
        const response = await fetch('http://localhost:8081/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                 email,  firstName,  lastName,  password,  phoneNumber,  userType
            }),
        });
        return await response.json();
    }
    async deleteProgrammerById(userId){
        const response = await fetch('http://localhost:8081/user/' + userId, {
            method: 'DELETE',
        });
        return await response.json();
    }
    async  updateProgrammerById(userId,  email,  firstName,  lastName,  password,  phoneNumber,  userType)
    {
        const response = await fetch('http://localhost:8081/user/' + userId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({userId,  email,  firstName,  lastName,  password,  phoneNumber,  userType}),
        });
        return await response.json();
    }



}