import bookService from "../services/bookService.js";
import likeService from "../services/likeService.js";



async function getView(context) {
    let bookId = context.params.id;
    await likeService.like(bookId);
    context.page.redirect(`/details/${context.params.id}`);


}

let likePage = {
    getView
}

export default likePage;