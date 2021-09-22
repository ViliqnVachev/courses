function validate(request) {
    //validate method
    let suportedMethods = ['GET', 'DELETE', 'POST', 'CONNECT'];
    if (request.method === undefined || !suportedMethods.includes(request.method)) {
        throw new Error(`Invalid request header: Invalid Method`);
    }
    //validate version
    let suportedVersions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    if (request.version === undefined || !suportedVersions.includes(request.version)) {
        throw new Error(`Invalid request header: Invalid Version`);
    }
    //validate uri
    let expression = /^\*$|^[a-zA-Z0-9\.]+$/;
    if (request.uri === undefined  || !expression.test(request.uri)) {
        throw new Error(`Invalid request header: Invalid URI`);
    }
    //validate message
    let expMessage = /^[^<>\\&'"]*$/
    if (request.message === undefined || !expMessage.test(request.message)) {
        throw new Error(`Invalid request header: Invalid Message`);
    }

    return request;
}

console.log(validate({
    method: 'GET',
    uri: 'svn.public.catalog',
    version: 'HTTP/1.1',
    message: ''
}



));