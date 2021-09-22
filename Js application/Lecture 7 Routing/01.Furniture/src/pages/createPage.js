import catalogService from "../services/catalogService.js";
import createTemplates from "../templates/createTemplate.js"

let form = undefined;

function getView(context) {
    form = {
        submitHandler,
        invalidFields: {
            make: true,
            model: true,
            year: true,
            description: true,
            price: true,
            img: true
        }

    }
    let template = createTemplates.createTemplate(form);
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
            let template = createTemplates.createTemplate(form);
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

        let result = await catalogService.create(furniture);

        e.target.reset();
        context.page.redirect('/dashboard');

    }

}

let createPage = {
    getView
}

export default createPage