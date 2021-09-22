import auth from "../services/authService.js";
import navTemplate from "../templates/navTemplate.js";




async function getView(context, next) {

    let nav = {
        currentPage: context.pathname,
        isLogedIn: auth.isLogged(),
        username: auth.getUserName()
    };
    let templateResult = navTemplate.template(nav);
    context.renderNavView(templateResult);
    next();
}


let navPage = {
    getView
}

export default navPage;