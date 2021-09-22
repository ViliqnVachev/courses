import { html } from "../node_modules/lit-html/lit-html.js";

function loadBtnTemplate(getBooks) {
    return html`
    <button @click="${getBooks}" id="loadBooks">LOAD ALL BOOKS</button>
    `;

}

let btnTemplates = {
    loadBtnTemplate
}

export default btnTemplates;