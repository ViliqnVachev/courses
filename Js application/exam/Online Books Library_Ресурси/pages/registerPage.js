import auth from "../services/authService.js";
import registerTemplate from "../templates/registerTemplate.js";


async function getView(context) {

    let form = {
        registerHandler
    }
    let template = registerTemplate.template(form);
    context.renderView(template);

    async function registerHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let password = formData.get('password');
        let repeatPass = formData.get('confirm-pass');
        let email = formData.get('email');

        if (email.trim() === '' || password.trim() === '') {
            alert('All fields are required');
            return;
        }
        if (password !== repeatPass) {
            alert('Passwords not match');
            return;
        }

        let user = {
            email,
            password
        }

        await auth.register(user);
        e.target.reset();
        context.page.redirect('/dashboard');
    }
}



let registerPage = {
    getView
};
export default registerPage;