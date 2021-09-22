import { html } from "../node_modules/lit-html/lit-html.js"

function empty() {

    return html`
    <p class="no-books">No books in database!</p>
    `;

}

function bookTemplate(book) {

    return html`
    <li class="otherBooks">
        <h3>${book.title}</h3>
        <p>Type: ${book.type}</p>
        <p class="img"><img src="${book.imageUrl}"></p>
        <a class="button" href="/details/${book._id}">Details</a>
    </li>
    `;

}

function booksTemplate(books) {
    return html`
<ul class="other-books-list">
    ${books.map(book => bookTemplate(book))}
</ul>
`;
}

function template(books) {
    return html`
<section id="dashboard-page" class="dashboard">
    <h1>Dashboard</h1>
    ${books.length > 0 ? booksTemplate(books) : empty()}

</section>
`;
}

export default {

    template
}