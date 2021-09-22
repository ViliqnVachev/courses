import catalogService from "../services/catalogService.js";
import editTemplates from "../templates/editTemplate.js";


let form = undefined;

async function getView(context) {
    let id = context.params.id;
    let currentFurniture = await catalogService.get(id);
    form = {
        submitHandler,
        values: {
            make: currentFurniture.make,
            model: currentFurniture.model,
            year: currentFurniture.year,
            description: currentFurniture.description,
            price: currentFurniture.price,
            img: currentFurniture.img,
            material: currentFurniture.material
        },
        invalidFields: {

        }

    }
    let template = editTemplates.editTemplate(form);
    context.renderView(template);

    async function submitHandler(e) {
        e.preventDefault();

        form.invalidFields = {};
        let formData = new FormData(e.target);

        let make = formData.get('make');
        let model = formData.get('model');
        let year = Number(formData.get('year'));
        let description = formData.get('description');
        let price = Number(formData.get('price'));
        let img = formData.get('img');
        let material = formData.get('material');

        if (make.length < 4) {
            form.invalidFields.make = true;
        }
        if (model.length < 4) {
            form.invalidFields.model = true;
        }
        if (!(year >= 1950 && year <= 2050)) {
            form.invalidFields.year = true;
        }
        if (description.length < 10) {
            form.invalidFields.description = true;
        }
        if (!(price > 0)) {
            form.invalidFields.price = true;
        }
        if (img.trim() === '') {
            form.invalidFields.img = true;
        }

        if (Object.keys(form.invalidFields).length > 0) {
            let template = editTemplates.editTemplate(form);
            return context.renderView(template);
        }

        let furniture = {
            make,
            model,
            year,
            description,
            price,
            img,
            material
        }

        let result = await catalogService.update(id, furniture);

        e.target.reset();
        context.page.redirect('/dashboard');

    }

}

let editPage = {
    getView
}

export default editPage