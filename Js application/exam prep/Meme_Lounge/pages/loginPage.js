
import auth from "../services/authService.js";
import { notificationRender } from "../services/notificationService.js";
import loginTemplates from "../templates/loginTemplate.js";


async function getView(context) {

    let form = {
        loginHandler
    }
    let template = loginTemplates.loginTemplate(form);
    context.renderView(template);

    async function loginHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let email = formData.get('email');
        let password = formData.get('password');
        if (email.trim() === '' || password === '') {
            let message = 'Error the email or password are empty';
            notificationRender(message);
            return;
        }
        let user = {
            email,
            password
        }

        let response = await auth.loggin(user);
        e.target.reset();
        context.page.redirect('/all');
    }
}


let loginPage = {
    getView
}

export default loginPage;