import { html } from "./../node_modules/lit-html/lit-html.js";

function catsTemplate(cat, statusFunc) {
    return html`
    <li>
        <img src="./images/${cat.imageLocation}.jpg" width="250" height="250" alt="Card image cap">
        <div class="info">
            <button @click=${statusFunc} class="showBtn">Show status code</button>
            <div class="status hidden" id="${cat.id}">
                <h4>Status Code: ${cat.statusCode}</h4>
                <p>${cat.statusMessage}</p>
            </div>
        </div>
    </li>
    `;

}

function allCatsTemplate(cats, statusFunc) {

    return html`
    <ul>
        ${cats.map(cat => catsTemplate(cat, statusFunc))}
    </ul>
    `;

}

let catsTemplates = {
    allCatsTemplate,
    catsTemplate

};

export default catsTemplates;