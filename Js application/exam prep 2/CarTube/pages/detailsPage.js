import auth from "../services/authService.js";
import carService from "../services/carService.js";
import detailsTemplate from "../templates/detailsTemplate.js";



// async function deleteHandler(context, id, e) {

//     let result = await carService.deleteItem(id);
//     context.page.redirect('/all')


// }

async function getView(context) {
    let id = context.params.id;
    //let deleteFunc = deleteHandler.bind(null, context, id);
    let car = await carService.get(id);
    let isOwner = auth.getUserId() === car._ownerId;
    let templateResult = detailsTemplate.template(car, isOwner);
    context.renderView(templateResult);
}


let detailsPage = {
    getView
}

export default detailsPage;