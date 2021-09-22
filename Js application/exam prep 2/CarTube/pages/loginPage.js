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
        let username = formData.get('username');
        let password = formData.get('password');
        if (username.trim() === '' || password === '') {
            alert('Empty fields');
            return;
        }
        let user = {
            username,
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