import { html } from "../node_modules/lit-html/lit-html.js"

function empty() {
    return html`
    <p class="no-cars"> You haven't listed any cars yet.</p>
    `;
}

function carTempate(car) {
    let model = `${car.brand} ${car.model}`

    return html`
    <div class="listing">
        <div class="preview">
            <img src="${car.imageUrl}">
        </div>
        <h2>${model}</h2>
        <div class="info">
            <div class="data-info">
                <h3>Year: ${car.year}</h3>
                <h3>Price: ${car.price} $</h3>
            </div>
            <div class="data-buttons">
                <a href="/details/${car._id}" class="button-carDetails">Details</a>
            </div>
        </div>
    </div>
`;

}

function template(cars) {
    return html`
    <section id="my-listings">
        <h1>My car listings</h1>
        <div class="listings">
            ${cars.length > 0 ? cars.map(car => carTempate(car)) : empty()}
    
        </div>
    </section>`;

}

export default {
    template
}