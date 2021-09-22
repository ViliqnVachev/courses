import bookService from "../services/bookService.js";



async function getView(context) {
    let isDeleted = await bookService.deleteItem(context.params.id);
    if (isDeleted) {
        context.page.redirect('/dashboard');
    } else {
        context.page.redirect(`/details/${context.params.id}`);
    }

}

let deletePage = {
    getView
}

export default deletePage;