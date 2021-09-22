import auth from "../services/authService.js";
import bookService from "../services/bookService.js";
import likeService from "../services/likeService.js";
import detailsTemplate from "../templates/detailsTemplate.js";


async function getView(context) {
    let id = context.params.id;
    let book = await bookService.get(id);
    let isOwner = auth.getUserId() === book._ownerId;
    let hasLike = await likeService.getLikeFromUser(id, auth.getUserId());
    let allLikes = await likeService.getLikes(id);
    console.log(hasLike);
    let templateResult = detailsTemplate.template(book, isOwner, auth.isLogged(), hasLike, allLikes);
    context.renderView(templateResult);
}


let detailsPage = {
    getView
}

export default detailsPage;