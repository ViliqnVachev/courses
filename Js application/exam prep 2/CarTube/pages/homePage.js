import homeTemplate from "../templates/homeTemplate.js";



async function getView(context) {

    let templateResult = homeTemplate.template();
    context.renderView(templateResult);
}


let homePage = {
    getView
}

export default homePage;