import { html } from "./../node_modules/lit-html/lit-html.js";
import { ifDefined } from "./../node_modules/lit-html/directives/if-defined.js"

function townTemplate(town) {
    return html`
    <li class="${ifDefined(town.class)}">${town.name}</li>
    `;

}

function allTownsTemplate(towns) {
    return html`
    <ul>
        ${towns.map(town => townTemplate(town))}
    </ul>
    `;
}
function matchesTemplate(matches) {
return html `
<p><span>${matches} matches found</span></p>
`
}

let townsTemplates = {
    allTownsTemplate,
    townTemplate,
    matchesTemplate
}

export default townsTemplates;