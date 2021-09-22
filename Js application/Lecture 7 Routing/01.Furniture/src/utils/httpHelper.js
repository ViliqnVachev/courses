import auth from "../services/authService.js";


async function jsonRequest(url, method, body, isAuth, skipResult) {
    try {
        if (method === undefined) {
            method = 'get';
        }
        let headers = {};

        if (['post', 'put', 'patch', 'get'].includes(method.toLowerCase())) {
            headers['Content-Type'] = 'application/json';
        }
        if (isAuth) {
            headers['X-Authorization'] = auth.getAuthToken();
        }

        let options = {
            method,
            headers
        };

        if (body !== undefined) {
            options.body = JSON.stringify(body);
        }

        let response = await fetch(url, options);

        if (!response.ok) {
            let message = await response.text();
            throw new Error(`${response.status}: ${response.statusText}\n${message}`);
        }

        let result = undefined;
        if (!skipResult) {
            result = await response.json();
        }
        return result;

    } catch (err) {
        alert(err);
    }
}




let httpService = {
    jsonRequest
}

export default httpService;