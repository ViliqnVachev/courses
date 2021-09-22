import { html } from "../node_modules/lit-html/lit-html.js";


function guest() {
    return html`
    <div class="guest">
        <div class="profile">
            <a href="/login">Login</a>
            <a href="/register">Register</a>
        </div>
        <a class="active" href="/home">Home Page</a>
    </div>
    `;
}

function loggedUser(nav) {
    return html`
<!-- Logged users -->
<div class="user">
    <a href="/create">Create Meme</a>
    <div class="profile">
        <span>Welcome, ${nav.email}</span>
        <a href="/profile">My Profile</a>
        <a href="/logout">Logout</a>
    </div>
</div>

`;
}

function navTemplate(nav) {
    return html`
    <a href="/all">All Memes</a>
    ${nav.isLogedIn ? loggedUser(nav) : guest()}
`;



}

let navTemplates = {
    navTemplate
}

export default navTemplates;