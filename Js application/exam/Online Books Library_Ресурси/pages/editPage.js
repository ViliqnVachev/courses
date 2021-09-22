import bookService from "../services/bookService.js";
import editTemplate from "../templates/editTemplate.js";


let form = undefined;

async function getView(context) {
    let book = await bookService.get(context.params.id);
    form = {
        submitHandler,
        book
    }
    let template = editTemplate.template(form);
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



        await bookService.update(context.params.id, book);

        e.target.reset();
        context.page.redirect(`/details/${context.params.id}`);

    }

}

let editPage = {
    getView
}

export default editPage