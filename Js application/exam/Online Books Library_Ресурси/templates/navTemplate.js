import { html } from "../node_modules/lit-html/lit-html.js"

function guest() {
    return html`
    <div id="guest">
        <a class="button" href="/login">Login</a>
        <a class="button" href="/register">Register</a>
    </div>
    `;
}

function loggedIn(email) {
    return html`
    <div id="user">
        <span>Welcome, ${email}</span>
        <a class="button" href="/myBooks">My Books</a>
        <a class="button" href="/create">Add Book</a>
        <a class="button" href="/logout">Logout</a>
    </div>
    `;
}

function template(nav) {
    return html`
<nav class="navbar">
    <section class="navbar-dashboard">
        <a href="/dashboard">Dashboard</a>
        ${nav.isLogedIn ? loggedIn(nav.email) : guest()}

    </section>
</nav>
`;
}

export default {

    template
}