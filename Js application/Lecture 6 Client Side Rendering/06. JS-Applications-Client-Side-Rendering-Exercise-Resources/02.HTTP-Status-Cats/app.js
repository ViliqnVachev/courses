import { cats } from "./catSeeder.js";
import { render } from "./node_modules/lit-html/lit-html.js";
import catsTemplates from "./templates/catTemplate.js";


let catsSection = document.querySelector('#allCats');

render(catsTemplates.allCatsTemplate(cats, catsStatusHandler), catsSection);

function catsStatusHandler(e) {
    let hiddenDiv = e.target.nextElementSibling;
    if (e.target.textContent == 'Show status code') {
        hiddenDiv.classList.remove('hidden');
        e.target.textContent = 'Hide status code'
    } else {
        hiddenDiv.classList.add('hidden');
        e.target.textContent = 'Show status code'
    }

}