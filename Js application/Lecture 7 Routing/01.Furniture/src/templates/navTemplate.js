import { html } from "../../node_modules/lit-html/lit-html.js";
import { ifDefined } from "../../node_modules/lit-html/directives/if-defined.js"

function template(nav) {
    return html`
    <h1><a href="/">Furniture Store</a></h1>
    <nav>
        <a id="catalogLink" href="/dashboard" class=${ifDefined(nav.currentPage.startsWith('/dashboard') ? 'active' :
            undefined)}>Dashboard </a>
        ${nav.isLogedIn ? html` <div id="user">
            <a id="createLink" href="/create" class=${ifDefined(nav.currentPage.startsWith('/create') ? 'active' :
                undefined)}>Create Furniture</a> <a id="profileLink" href="/my-furniture"
                class=${ifDefined(nav.currentPage.startsWith('/my-furniture') ? 'active' : undefined)}>My Publications</a>
            <a id="logoutBtn" href="/logout">Logout</a>
        </div>`: html` <div id="guest">
            <a id="loginLink" href="/login" class=${ifDefined(nav.currentPage.startsWith('/login') ? 'active' :
                undefined)}>Login</a>
            <a id="registerLink" href="/register" class=${ifDefined(nav.currentPage.startsWith('/register') ? 'active' :
                undefined)}>Register</a>
        </div>`}
    </nav>
`;
}

let navTempates = {
    template
}

export default navTempates;