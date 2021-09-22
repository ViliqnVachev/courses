import { html } from "./../node_modules/lit-html/lit-html.js";
import { ifDefined } from "./../node_modules/lit-html/directives/if-defined.js"

function tdTemplate(data) {
    return html`
    ${data.map(e => html`
    <tr class="${ifDefined(e.class)}">
        <td>${e.fullName}</td>
        <td>${e.email}</td>
        <td>${e.course}</td>
    </tr>
    `)}
    `
}


let tableTemplates = {
    tdTemplate
}

export default tableTemplates;