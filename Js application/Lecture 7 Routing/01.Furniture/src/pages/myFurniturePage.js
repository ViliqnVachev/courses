import auth from "../services/authService.js";
import catalogService from "../services/catalogService.js";
import myFurnitureTemplates from "../templates/myFurnitureTemplate.js";
import myFurnitureTemplate from "../templates/myFurnitureTemplate.js";



async function getView(context) {
    let furnitures = await catalogService.getMyData(auth.getUserId());
    let templateResult = myFurnitureTemplates.myFurnitureTemplate(furnitures);
    context.renderView(templateResult);
}


let myFurniturePage = {
    getView
}

export default myFurniturePage;