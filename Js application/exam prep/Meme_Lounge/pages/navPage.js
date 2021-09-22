import auth from "../services/authService.js";
import navTemplates from "../templates/navTemplate.js";



async function getView(context, next) {

    let nav = {
        currentPage: context.pathname,
        isLogedIn: auth.isLogged(),
        email: auth.getEmail()
    };
    let templateResult = navTemplates.navTemplate(nav);
    context.renderNavView(templateResult);
    next();
}


let navPage = {
    getView
}

export default navPage;