import { html } from "../node_modules/lit-html/lit-html.js"


function template(car, isOwner) {
    return html`
    <section id="listing-details">
        <h1>Details</h1>
        <div class="details-info">
            <img src="${car.imageUrl}">
            <hr>
            <ul class="listing-props">
                <li><span>Brand:</span>${car.brand}</li>
                <li><span>Model:</span>${car.model}</li>
                <li><span>Year:</span>${car.year}</li>
                <li><span>Price:</span>${car.price}$</li>
            </ul>
    
            <p class="description-para">${car.description}</p>
            ${isOwner ? html`<div class="listings-buttons">
                <a href="/edit/${car._id}" class="button-list">Edit</a>
                <a href="/delete/${car._id}" class="button-list">Delete</a>
            </div>`: html``}
    
        </div>
    </section>
    `;

}

export default {
    template
}