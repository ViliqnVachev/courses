import auth from "../services/authService.js";
import navTempates from "../templates/navTemplate.js";

async function getView(context, next) {
   
    let nav = {
        currentPage: context.pathname,
        isLogedIn: auth.isLogged()
    };
    let templateResult = navTempates.template(nav);
    context.renderNavView(templateResult);
    next();
}


let navPage = {
    getView
}

export default navPage;