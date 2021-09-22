import bookService from "../services/bookService.js";
import dashboardTemplate from "../templates/dashboardTemplate.js";



async function getView(context) {
    let books = await bookService.getAll();
    let templateResult = dashboardTemplate.template(books);
    context.renderView(templateResult);
}


let dashboardPage = {
    getView
}

export default dashboardPage;