import memeService from "../services/memeService.js";
import { notificationRender } from "../services/notificationService.js";
import createTemplates from "../templates/createTemplate.js";

let form = undefined;

function getView(context) {
    form = {
        submitHandler,
    }
    let template = createTemplates.createTemplate(form);
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
            notificationRender(message);
            return;
        }
        let meme = {
            title,
            description,
            imageUrl
        }


        let result = await memeService.create(meme);

        e.target.reset();
        context.page.redirect('/all');

    }

}

let createPage = {
    getView
}

export default createPage