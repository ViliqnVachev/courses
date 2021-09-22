import carService from "../services/carService.js";
import searchTemplate from "../templates/searchTemplate.js";



async function getView(context) {

    let templateResult = searchTemplate.template(searchHandler, undefined);
    context.renderView(templateResult);

    async function searchHandler(e) {
        let year = document.querySelector('#search-input').value;
        let cars = await carService.search(year);
        let templateResult = searchTemplate.template(searchHandler, cars);
        context.renderView(templateResult);
    }
}


let searchPage = {
    getView
}

export default searchPage;