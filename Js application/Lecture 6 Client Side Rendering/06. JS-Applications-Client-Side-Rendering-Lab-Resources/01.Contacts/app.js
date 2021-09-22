import { render } from "./node_modules/lit-html/lit-html.js";
import { contacts } from "./contacts.js";
import contactTemplates from "./templates/contactTemplate.js";


let container = document.querySelector('#contacts');

render(contactTemplates.allContactsTemplate(contacts, detailsHander), container);

function detailsHander(e) {

    let detailsDivElement = e.target.nextElementSibling;
    if (e.target.textContent === 'Details') {
        detailsDivElement.classList.remove('details')
        e.target.textContent = 'Hide';
    } else {
        detailsDivElement.classList.add('details')
        e.target.textContent = 'Details';
    }


}