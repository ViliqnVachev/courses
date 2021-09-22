import httpService from "./httpService.js";
import viewChanger from "./viewChangers.js";
let url = 'http://localhost:3030/users/logout'

function setAuthToken(token) {
    localStorage.setItem('token', token)
}

function getAuthToken() {
    return localStorage.getItem('token');
}

function isLoggedIn() {
    return localStorage.getItem('token') !== null;
}

function getUserId() {
    return localStorage.getItem('userID');
}

function setUserId(id) {
    localStorage.setItem('userID', id);
}

function getUserEmail() {
    return localStorage.getItem('userEmail');
}

function setUserEmail(userEmail) {
    localStorage.setItem('userEmail', userEmail);
}

async function logout() {
    let result = await httpService.jsonRequest(url, 'get', undefined, true, true);
    localStorage.clear();
    return viewChanger.redirectTo('login');
}

let auth = {
    getAuthToken,
    setAuthToken,
    isLoggedIn,
    logout,
    getUserId,
    setUserId,
    setUserEmail,
    getUserEmail
}

export default auth;