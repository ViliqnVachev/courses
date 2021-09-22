import { html } from "../node_modules/lit-html/lit-html.js"

function guest() {

    return html`
    <div id="guest">
        <a href="/login">Login</a>
        <a href="/register">Register</a>
    </div>
    `;

}

function loggedUser(username) {
    return html`
<div id="profile">
    <a>Welcome ${username}</a>
    <a href="/myCars">My Listings</a>
    <a href="/create">Create Listing</a>
    <a href="/logout">Logout</a>
</div>
`;
}

function template(nav) {
    return html`
    <nav>
        <a class="active" href="/home">Home</a>
        <a href="/all">All Listings</a>
        <a href="/search">By Year</a>
        ${nav.isLogedIn ? loggedUser(nav.username) : guest()}
    
    </nav>
    `;

}

export default {
    template
}