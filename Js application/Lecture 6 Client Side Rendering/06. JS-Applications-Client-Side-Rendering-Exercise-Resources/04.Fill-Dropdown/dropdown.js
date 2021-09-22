import { render } from "./node_modules/lit-html/lit-html.js";
import optionsTemplates from "./templates/optionTemplate.js";

let url = 'http://localhost:3030/jsonstore/advanced/dropdown';

let selectMenu = document.querySelector('#menu');
let form = document.querySelector('#submit');


loadOptions()
let options = [];




async function loadOptions() {
    let response = await fetch(url);
    let optionsData = await response.json();

    console.log(optionsData);
    options = Object.values(optionsData);
    render(optionsTemplates.optionTemplate(options), selectMenu);
    form.addEventListener('submit', addOptionHandler)
}
async function addOptionHandler(e) {
    e.preventDefault();
    let formData = new FormData(e.target)
    let text = formData.get('text');
    let newOption = { text };

    let response = await fetch(url, {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newOption)
    })
    if (response.ok) {
        let addedOption = await response.json();
        options.push(addedOption);
        render(optionsTemplates.optionTemplate(options), selectMenu);
        e.target.reset();
    }

}

