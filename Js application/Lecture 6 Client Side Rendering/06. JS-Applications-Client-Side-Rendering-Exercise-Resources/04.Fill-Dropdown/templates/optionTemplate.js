import { html } from "./../node_modules/lit-html/lit-html.js";


function optionTemplate(options) {
    return html`
    ${options.map(e => html`<option value=${e._id}>${e.text}</option>`)}
    `;

}

let optionsTemplates = {
    optionTemplate
}

export default optionsTemplates;