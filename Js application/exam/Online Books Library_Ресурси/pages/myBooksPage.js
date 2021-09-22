import auth from "../services/authService.js";
import bookService from "../services/bookService.js";
import myBooksTemplate from "../templates/myBooksTemplate.js";


async function getView(context) {
    let books = await bookService.getMyData(auth.getUserId());
    let templateResult = myBooksTemplate.template(books);
    context.renderView(templateResult);
}


let myBooksPage = {
    getView
}

export default myBooksPage;