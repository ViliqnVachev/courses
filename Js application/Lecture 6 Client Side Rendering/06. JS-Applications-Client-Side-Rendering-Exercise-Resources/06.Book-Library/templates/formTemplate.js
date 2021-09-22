import { html } from "../node_modules/lit-html/lit-html.js";
import { ifDefined } from "../node_modules/lit-html/directives/if-defined.js";

function formTemplate(submitForm, editForm) {
    return html`
    <form id="add-form" @submit=${submitForm.submitHandler} class="${ifDefined(submitForm.class)}">
        <h3>Add book</h3>
        <label>TITLE</label>
        <input type="text" name="title" placeholder="Title...">
        <label>AUTHOR</label>
        <input type="text" name="author" placeholder="Author...">
        <input type="submit" value="Submit">
    </form>
    
    <form id="edit-form" @submit=${editForm.editHandler} class="${ifDefined(editForm.class)}">
        <input id="book-id" type="hidden" name="id" value=${ifDefined(editForm.id)}>
        <h3>Edit book</h3>
        <label>TITLE</label>
        <input type="text" name="title" value=${ifDefined(editForm.title)}>
        <label>AUTHOR</label>
        <input type="text" name="author" value=${ifDefined(editForm.author)}>
        <input type="submit" value="Save">
    </form>
    `;

}

let formTemplates = {
    formTemplate
}

export default formTemplates;