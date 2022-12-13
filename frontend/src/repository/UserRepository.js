
export default class UserRepository {
    async findUserById(userId){
        const response = await fetch("http://localhost:8081/user/" + userId, {
            method: 'GET',
        });
        return await response.json()
    }

    async getAllProgrammers() {
        const response = await fetch('http://localhost:8081/users');
        return await response.json();
    }


    async createProgrammers ( email,  first_name,  last_name,  password,  phone_number) {
        const response = await fetch('http://localhost:8081/users/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                 email,  first_name,  last_name,  password,  phone_number
            }),
        });
        return await response.json();
    }
    async deleteProgrammerById(userId){
        const response = await fetch('http://localhost:8081/users/' + userId, {
            method: 'DELETE',
        });
        return await response.json();
    }
    async  updateProgrammerById(userId,  email,  firstName,  lastName,  phoneNumber)
    {
        const response = await fetch('http://localhost:8081/user/' + userId, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({  email,  firstName,  lastName, phoneNumber}),
        });
        return await response.json();
    }

    async loginUser ( email, password) {
        const response = await fetch('http://localhost:8081/users/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email, password
            }),
        });
        return await response.json();
    }

}