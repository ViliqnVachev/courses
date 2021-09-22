import auth from "../utils/auth.js";
import httpService from "../utils/httpService.js";
import viewChanger from "../utils/viewChangers.js";

let section = undefined;
let url = 'http://localhost:3030/users/register'

function sectionSetup(element) {
    section = element
    let form = section.querySelector('#register-form');
    form.addEventListener('submit', regiserHandler);
}

async function getView() {
    return section;
}

async function regiserHandler(e) {
    e.preventDefault();

    let form = e.target;
    let formData = new FormData(form);
    let email = formData.get('email');
    let password = formData.get('password');
    let repeatPassword = formData.get('repeatPassword');

    if (password === '' || email === '' || password !== repeatPassword || password.length < 6) {
        alert('Incorect data');
        return;
    }

    let user = {
        email,
        password
    }

    let result = await httpService.jsonRequest(url, 'post', user);

    auth.setAuthToken(result.accessToken);
    auth.setUserId(result._id);
    auth.setUserEmail(result.email);
    e.target.reset();

    viewChanger.navigateTo('home');
}

let registerPage = {
    sectionSetup,
    getView
}

export default registerPage;