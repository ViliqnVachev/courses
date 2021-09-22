import { html } from "../node_modules/lit-html/lit-html.js"

function template(book, isOwner, isLogged, hasLike, allLikes) {
    return html`
<section id="details-page" class="details">
    <div class="book-information">
        <h3>${book.title}</h3>
        <p class="type">Type: ${book.type}</p>
        <p class="img"><img src="${book.imageUrl}"></p>
        <div class="actions">
            <!-- Edit/Delete buttons ( Only for creator of this book )  -->
            ${isOwner ? html` <a class="button" href="/edit/${book._id}">Edit</a>
            <a class="button" href="/delete/${book._id}">Delete</a>` : html``}


            <!-- Bonus -->
            <!-- Like button ( Only for logged-in users, which is not creators of the current book ) -->
            ${(isLogged && !isOwner && hasLike == 0) ? html`<a class="button" href="/like/${book._id}">Like</a>` :
            html``}


            <!-- ( for Guests and Users )  -->
            <div class="likes">
                <img class="hearts" src="/images/heart.png">
                <span id="total-likes">Likes: ${allLikes}</span>
            </div>
            <!-- Bonus -->
        </div>
    </div>
    <div class="book-description">
        <h3>Description:</h3>
        <p>${book.description}</p>
    </div>
</section>
`;
}

export default {

    template
}