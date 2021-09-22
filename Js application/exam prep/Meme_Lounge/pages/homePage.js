import homeTemplates from "../templates/homeTemplate.js";


async function getView(context) {

    let templateResult = homeTemplates.homeTemplate();
    context.renderView(templateResult);
}


let homePage = {
    getView
}

export default homePage;