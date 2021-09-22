import catalogService from "../services/catalogService.js";
import dashboardTemplate from "../templates/dashboardTemplate.js";

async function getView(context) {
    let furnitures = await catalogService.getAll();
    let templateResult = dashboardTemplate.dashboardTemplate(furnitures);
    context.renderView(templateResult);
}


let dashboardPage = {
    getView
}

export default dashboardPage;