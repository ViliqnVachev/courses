import auth from "../services/authService.js";
import loginTemplate from "../templates/loginTemplate.js";


async function getView(context) {

    let form = {
        loginHandler
    }
    let template = loginTemplate.template(form);
    context.renderView(template);

    async function loginHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let email = formData.get('email');
        let password = formData.get('password');
        if (email.trim() === '' || password === '') {
            alert('All fields are required');
            return;
        }
        let user = {
            email,
            password
        }

        await auth.loggin(user);
        e.target.reset();
        context.page.redirect('/dashboard');
    }
}


let loginPage = {
    getView
}

export default loginPage;