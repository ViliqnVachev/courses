import { html } from "../node_modules/lit-html/lit-html.js";

function memeTemplate(meme) {
    return html`
<div class="meme">
    <div class="card">
        <div class="info">
            <p class="meme-title">${meme.title}</p>
            <img class="meme-image" alt="meme-img" src="${meme.imageUrl}">
        </div>
        <div id="data-buttons">
            <a class="button" href="/details/${meme._id}">Details</a>
        </div>
    </div>
</div>
    `;

}

function emptyMemes() {
    return html`<p class="no-memes">No memes in database.</p>`;
}

function allMemesTemplate(memes) {
    return html`
    <section id="meme-feed">
        <h1>All Memes</h1>
        <div id="memes">
            ${memes.length > 0 ? memes.map(m => memeTemplate(m)) : emptyMemes()}    
        </div>
    </section>
    `;
}

let allMemesTempates = {
    allMemesTemplate
}

export default allMemesTempates;