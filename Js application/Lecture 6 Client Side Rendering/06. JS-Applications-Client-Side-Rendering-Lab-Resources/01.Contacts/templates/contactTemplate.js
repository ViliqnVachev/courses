import { html } from "./../node_modules/lit-html/lit-html.js";

function contactTemplate(contact, detailsHandler) {
    let template = html`
    <div class="info">
        <h2>Name: ${contact.name}</h2>
        <button @click=${detailsHandler} class="detailsBtn">Details</button>
        <div class="details" id=${contact.id}>
            <p>Phone number: ${contact.phoneNumber}</p>
            <p>Email: ${contact.email}</p>
        </div>
    </div>
    `;
    return template;

}

function allContactsTemplate(contacts, detailsHandler) {
    let template = html`
<div class="contact card">
    <div>
        <i class="far fa-user-circle gravatar"></i>
    </div>
    ${contacts.map(e => contactTemplate(e, detailsHandler))}
</div>`
    return template;

}




let contactTemplates = {
    allContactsTemplate,
    contactTemplate
};

export default contactTemplates;