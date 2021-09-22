import { html } from "../node_modules/lit-html/lit-html.js";

function memeTemplate(meme) {
    return html`
    <div class="user-meme">
        <p class="user-meme-title">${meme.title}</p>
        <img class="userProfileImage" alt="meme-img" src="${meme.imageUrl}">
        <a class="button" href="/details/${meme._id}">Details</a>
    </div>
    `;

}

function emptyMemes() {
    return html`
    <p class="no-memes">No memes in database.</p>
    `;
}

function profileTemplate(memes, user) {
    return html`
    <section id="user-profile-page" class="user-profile">
        <article class="user-info">
            <img id="user-avatar-url" alt="user-profile" src=${user.gender === 'male'
                 ? "/images/male.png" : "/images/female.png"}> <div class="user-content">
            <p>Username: ${user.username}</p>
            <p>Email: ${user.email}</p>
            <p>My memes count: ${memes.length}</p>
            </div>
        </article>
        <h1 id="user-listings-title">User Memes</h1>
        <div class="user-meme-listings">
            ${memes.length > 0 ? memes.map(m => memeTemplate(m)) : emptyMemes()}
    
        </div>
    </section>
    `;
}

let profileTemplates = {
    profileTemplate
}

export default profileTemplates;