import httpService from "../utils/httpHelper.js";


let url = 'http://localhost:3030/users';

function getAuthToken() {
    return localStorage.getItem('token');
}

function getUserId() {
    return localStorage.getItem('userId');
}
function getEmail() {
    return localStorage.getItem('email');
}

function isLogged() {
    return localStorage.getItem('token') !== null;
}

function getGender() {
    return localStorage.getItem('gender');
}

function getUserName() {
    return localStorage.getItem('userName');
}

async function register(user) {

    let responseData = await httpService.jsonRequest(`${url}/register`, 'post', user);
    localStorage.setItem('token', responseData.accessToken);
    localStorage.setItem('userId', responseData._id);
    localStorage.setItem('email', responseData.email);
    localStorage.setItem('gender', responseData.gender);
    localStorage.setItem('userName', responseData.username);
}

async function loggin(user) {

    let responseData = await httpService.jsonRequest(`${url}/login`, 'post', user);
    localStorage.setItem('token', responseData.accessToken);
    localStorage.setItem('userId', responseData._id);
    localStorage.setItem('email', responseData.email);
    localStorage.setItem('gender', responseData.gender);
    localStorage.setItem('userName', responseData.username);
}

async function logout() {
    let responseData = await httpService.jsonRequest(`${url}/logout`, 'get', undefined, true, true);
    localStorage.clear();
}

let auth = {
    getAuthToken,
    getUserId,
    isLogged,
    loggin,
    register,
    logout,
    getEmail,
    getGender,
    getUserName
}

export default auth;