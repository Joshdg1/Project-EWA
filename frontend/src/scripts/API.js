// This class is meant as an wrapper for all API requests:
// - Simplify repositories
// - Add authentication to requests

export default class API {
    //General function to send request
    static async send(url, method, body = false){

        // Prepare request parameters
        let request = {
            method: method
        }

        // Insert authentication token if set
        // const token = sessionStorage.getItem("token");
        // if (token){
        //
        // }

        // Insert body if given
        if (body){
            request.headers = {
                'Content-Type': 'application/json',
            };

            request.body = JSON.stringify(body);
        }

        // TODO: get url from env (had a bug and didn't have the time to fix it)
        // Send request
        const response = await fetch(
            `http://localhost:8081${url}`,
            request
        );

        console.log(`API: ${method}`, url);

        return await response.json();
    }

    static async post(url, body){
        return await this.send(url, "POST", body);
    }

    static async get(url){
        return await this.send(url, "GET");
    }

    static async put(url){
        return await this.send(url, "PUT");
    }

    static async delete(url){
        return await this.send(url, "DELETE");
    }
}