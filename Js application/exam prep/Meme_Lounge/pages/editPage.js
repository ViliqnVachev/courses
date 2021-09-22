import memeService from "../services/memeService.js";
import { notificationRender } from "../services/notificationService.js";
import editTemplates from "../templates/editTemplate.js";


let form = undefined;

async function getView(context) {
    let meme = await memeService.get(context.params.id)
    form = {
        submitHandler,
        meme
    }
    let template = editTemplates.editTemplate(form);
    context.renderView(template);

    async function submitHandler(e) {
        e.preventDefault();
        form.invalidFields = {};
        let formData = new FormData(e.target);

        let title = formData.get('title');
        let description = formData.get('description');
        let imageUrl = formData.get('imageUrl');

        if (title.trim() === '' || description.trim() === '' || imageUrl.trim() === '') {

            let message = 'The filds must not be empty';
            notificationRender
            (message);
            return
        }
        let meme = {
            title,
            description,
            imageUrl
        }


        let result = await memeService.update(context.params.id, meme);

        e.target.reset();
        context.page.redirect(`/details/${context.params.id}`);

    }

}

let editPage = {
    getView
}

export default editPage;