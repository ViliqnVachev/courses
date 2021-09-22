export async function jsonRequest(url, method, body) {
    try {
        if (method === undefined) {
            method = 'get';
        }
        let headers = {};

        if (['post', 'put', 'patch'].includes(method.toLowerCase())) {
            headers['Content-Type'] = 'application/json';
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

        let result = await response.json();
        return result;

    } catch (err) {
        alert(err);
    }

}