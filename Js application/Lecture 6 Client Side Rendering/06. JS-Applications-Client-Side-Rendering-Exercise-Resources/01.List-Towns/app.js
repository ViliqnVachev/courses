import { render } from "./node_modules/lit-html/lit-html.js";
import townTemplates from "./templates/townTemplate.js";

let form = document.querySelector('.content');
let rootContainer = document.querySelector('#root');

form.addEventListener('submit', loadTownsHandler);

function loadTownsHandler(e) {
    e.preventDefault();
    let form = new FormData(e.target);
    let towns = form.get('towns').split(', ');
    render(townTemplates.allTownsTemplate(towns), rootContainer);
    e.target.reset();
}