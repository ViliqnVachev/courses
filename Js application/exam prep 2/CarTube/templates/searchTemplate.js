import { html } from "../node_modules/lit-html/lit-html.js"

function search(car) {
    let model = `${car.brand} ${car.model}`

    return html`
    <h2>Results:</h2>
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
    `

}

function empty() {
    return html`

<div class="listings">
    <p class="no-cars"> No results.</p>
</div>
`;
}

function template(searchFunc, cars) {
    return html`
<section id="search-cars">
    <h1>Filter by year</h1>

    <div class="container">
        <input id="search-input" type="text" name="search" placeholder="Enter desired production year">
        <button @click=${searchFunc} class="button-list">Search</button>
    </div>
    ${cars === undefined ? html`` : (cars.length > 0 ? cars.map(car => search(car)) : empty())}

</section>
    `;

}

export default {
    template
}