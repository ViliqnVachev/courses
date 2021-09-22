import auth from "../services/authService.js";


async function getView(context) {
    await auth.logout();
    context.page.redirect('/home');
}

let logoutPage = {
    getView
}

export default logoutPage;