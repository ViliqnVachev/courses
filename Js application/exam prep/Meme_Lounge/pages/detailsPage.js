import auth from "../services/authService.js";
import memeService from "../services/memeService.js";
import detailsTemplates from "../templates/detailsTemplate.js";


async function deleteHandler(context, id, e) {

    let result = await memeService.deleteItem(id);
    context.page.redirect('/all')


}

async function getView(context) {
    let id = context.params.id;
    let deleteFunc = deleteHandler.bind(null, context, id);
    let meme = await memeService.get(id);
    let isOwner = auth.getUserId() === meme._ownerId;
    let templateResult = detailsTemplates.detailsTemplate(meme, deleteFunc, isOwner);
    context.renderView(templateResult);
}


let detailsPage = {
    getView
}

export default detailsPage;