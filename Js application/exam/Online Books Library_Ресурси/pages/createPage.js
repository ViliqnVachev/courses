import bookService from "../services/bookService.js";
import createTemplate from "../templates/createTemplate.js";

let form = undefined;

function getView(context) {
    form = {
        submitHandler,
    }
    let template = createTemplate.template(form);
    context.renderView(template);

    async function submitHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);

        let title = formData.get('title');
        let description = formData.get('description');
        let imageUrl = formData.get('imageUrl');
        let type = formData.get('type');

        if (title.trim() === '' || description.trim() === '' || imageUrl.trim() === '' || type.trim() === '') {
            alert('All fields are required');
            return;
        }

        let book = {
            title,
            description,
            imageUrl,
            type
        }

        await bookService.create(book);

        e.target.reset();
        context.page.redirect('/dashboard');

    }

}

let createPage = {
    getView
}

export default createPage