import auth from "../services/authService.js";
import registerTemplates from "../templates/registerTemplate.js";

async function getView(context) {

    let form = {
        registerHandler
    }
    let template = registerTemplates.template(form);
    context.renderView(template);

    async function registerHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let password = formData.get('password');
        let repassword = formData.get('rePass');

        if (password !== repassword) {
            alert('The passwords not match')
            return;
        }

        let user = {
            email: formData.get('email'),
            password
        }

        let response = await auth.register(user);
        e.target.reset();
        context.page.redirect('/dashboard');
    }
}



let registerPage = {
    getView
};
export default registerPage;