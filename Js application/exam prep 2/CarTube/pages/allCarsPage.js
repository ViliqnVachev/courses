import carService from "../services/carService.js";
import allCarsTemplate from "../templates/allCarsTemplate.js";


async function getView(context) {
    let cars = await carService.getAll();
    let templateResult = allCarsTemplate.template(cars);
    context.renderView(templateResult);
}


let allCarsPage = {
    getView
}

export default allCarsPage;