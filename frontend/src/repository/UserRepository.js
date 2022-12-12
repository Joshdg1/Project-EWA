export default class UserRepository {
    async findUserById(userId){
        const response = await fetch("http://localhost:8081/user/" + userId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllProgrammers() {
        const response = await fetch('http://localhost:8081/user');
        return await response.json();
    }

    async createProgrammers (  email,  firstName,  lastName,  password,  phoneNumber,  userType) {
        const response = await fetch('http://localhost:8081/user/add', {
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