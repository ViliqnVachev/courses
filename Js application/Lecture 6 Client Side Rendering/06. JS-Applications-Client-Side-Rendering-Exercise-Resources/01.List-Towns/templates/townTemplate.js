import { html } from "./../node_modules/lit-html/lit-html.js";

function townTemplate(town) {
    return html`
    <li>${town}</li>
`;
}

function allTownsTemplate(towns) {
    return html`
    <ul>
        ${towns.map(town => townTemplate(town))}
    </ul>
    `;
}


let townTemplates = {
    townTemplate,
    allTownsTemplate
}

export default townTemplates;