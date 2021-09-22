import auth from "../services/authService.js";
import loginTemplates from "../templates/loginTemplate.js";



async function getView(context) {

    let form = {
        loginHandler
    }
    let template = loginTemplates.template(form);
    context.renderView(template);

    async function loginHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.target);
        let user = {
            email: formData.get('email'),
            password: formData.get('password')
        }

        let response = await auth.loggin(user);
        e.target.reset();
        context.page.redirect('/dashboard');
    }
}


let loginPage = {
    getView
}

export default loginPage;