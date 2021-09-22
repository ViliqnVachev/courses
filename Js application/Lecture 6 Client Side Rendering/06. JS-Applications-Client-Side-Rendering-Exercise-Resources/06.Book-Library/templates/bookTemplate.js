import { defaultTemplateProcessor, html } from "../node_modules/lit-html/lit-html.js";

function bookTemplate(books, editFunction, deleteFunction) {
    return html`${books.map(book => html`
<tr>
    <td>${book.title}</td>
    <td>${book.author}</td>
    <td id=${book._id}>
        <button @click=${editFunction}>Edit</button>
        <button @click=${deleteFunction}>Delete</button>
    </td>
</tr>`)}
    `;
}

function tableTemplate() {
    return html`
    <table>
        <thead>
            <tr>
                <th>Title</th>
                <th>Author</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody id="books">
            <tr>
                <td>
                </td>
                <td>
                </td>
                <td>
                </td>
            </tr>
        </tbody>
    </table>
    `;

}

let bookTemplates = {
    bookTemplate,
    tableTemplate
}

export default bookTemplates;