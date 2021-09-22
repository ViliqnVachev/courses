import auth from "../services/authService.js";
import { notificationRender } from "../services/notificationService.js";
import registerTemplates from "../templates/registerTemplate.js";

async function getView(context) {

    let form = {
        registerHandler
    }
    let template = registerTemplates.registerTemplate(form);
    context.renderView(template);

    async function registerHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let password = formData.get('password');
        let repassword = formData.get('repeatPass');
        let username = formData.get('username');
        let email = formData.get('email');
        let gender = formData.get('gender');

        if (email.trim() == '' || username.trim() === '' || password.trim() === '') {
            let message = 'All fields are required';
            notificationRender(message);
            return;
        }
        if (password !== repassword) {
            let message = 'The passwords are different';
            notificationRender(message);
            return;
        }

        let user = {
            email,
            username,
            password,
            gender
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