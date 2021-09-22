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
        let repeatPass = formData.get('repeatPass');
        let username = formData.get('username');

        if (username.trim() === '' || password.trim() === '') {
            alert('Empty fields');
            return;
        }
        if (password !== repeatPass) {
            alert('Passwords not match');
            return;
        }

        let user = {
            username,
            password
        }

        let response = await auth.register(user);
        e.target.reset();
        context.page.redirect('/all');
    }
}



let registerPage = {
    getView
};
export default registerPage;