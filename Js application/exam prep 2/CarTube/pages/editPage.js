import carService from "../services/carService.js";
import editTemplate from "../templates/editTemplate.js";


let form = undefined;

async function getView(context) {
    let car = await carService.get(context.params.id);
    form = {
        submitHandler,
        car
    }
    let template = editTemplate.template(form);
    context.renderView(template);

    async function submitHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);

        let brand = formData.get('brand');
        let model = formData.get('model');
        let description = formData.get('description');
        let year = formData.get('year');
        let imageUrl = formData.get('imageUrl');
        let price = formData.get('price');

        if (brand.trim() === '' || model.trim() === '' || description.trim() === '' || year.trim() === '' || imageUrl.trim() === '' || price.trim() === '') {
            alert('The filds must not be empty');
            return;
        }
        if (Number(year) < 0 || Number(price) < 0) {
            alert('The year and price must be > 0');
            return;
        }
        let car = {
            brand,
            model,
            description,
            year: Number(year),
            imageUrl,
            price: Number(price)
        }



        let result = await carService.update(context.params.id, car);

        e.target.reset();
        context.page.redirect(`/details/${context.params.id}`);

    }

}

let editPage = {
    getView
}

export default editPage