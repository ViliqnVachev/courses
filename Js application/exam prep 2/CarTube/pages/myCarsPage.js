import auth from "../services/authService.js";
import carService from "../services/carService.js";
import myCarTemplate from "../templates/myCarTemplate.js";



async function getView(context) {
    let cars = await carService.getMyData(auth.getUserId());
    let templateResult = myCarTemplate.template(cars);
    context.renderView(templateResult);
}


let myCarsPage = {
    getView
}

export default myCarsPage;