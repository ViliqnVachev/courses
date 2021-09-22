import carService from "../services/carService.js";


async function getView(context) {
    await carService.deleteItem(context.params.id);
    context.page.redirect('/all');
}

let deletePage = {
    getView
}

export default deletePage;