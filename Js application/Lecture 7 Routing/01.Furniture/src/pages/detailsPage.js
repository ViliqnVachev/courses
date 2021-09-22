import auth from "../services/authService.js";
import catalogService from "../services/catalogService.js";
import detailsTemplates from "../templates/detailsTemplate.js";

async function deleteHandler(context, id, e) {
    let confirmed = confirm('Are you sure you want to delete this');

    if (confirmed) {
        let result = await catalogService.deleteFurniture(id);
        context.page.redirect('/dashboard')
    }
 
}

async function getView(context) {
    let id = context.params.id;
    let deleteFunc = deleteHandler.bind(null, context, id);
    let furniture = await catalogService.get(id);
    let isOwner = auth.getUserId() === furniture._ownerId;
    let templateResult = detailsTemplates.template(furniture, deleteFunc, isOwner);
    context.renderView(templateResult);
}


let detailsPage = {
    getView
}

export default detailsPage;