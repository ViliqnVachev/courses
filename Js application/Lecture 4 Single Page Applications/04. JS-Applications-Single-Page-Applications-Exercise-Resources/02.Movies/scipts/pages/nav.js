import auth from "../utils/auth.js";
import loginPage from "./loginPage.js";
import registerPage from "./registerPage.js";

let section = undefined;

function sectionSetup(element) {

    section = element
}

async function getView() {

    return section;
}

async function updateNavigation() {
    let welcomeMsg = section.querySelector('#welcome');
    let logoutBtn = section.querySelector('#logout');
    let loginBtn = section.querySelector('#login');
    let registerBtn = section.querySelector('#register');

    if (auth.isLoggedIn()) {
        welcomeMsg.textContent = `Welcome ${auth.getUserEmail()}`;
        logoutBtn.className = 'nav-link link';
        loginBtn.className = 'hidden';
        registerBtn.className = 'hidden'
    } else {
        welcomeMsg.textContent = `Welcome email`;
        logoutBtn.className = 'hidden';
        loginBtn.className = 'nav-link link';
        registerBtn.className = 'nav-link link';
    }

}

let nav = {
    sectionSetup,
    getView,
    updateNavigation
}

export default nav;