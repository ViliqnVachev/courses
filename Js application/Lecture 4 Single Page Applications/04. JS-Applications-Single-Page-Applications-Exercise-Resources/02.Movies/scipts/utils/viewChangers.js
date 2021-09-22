import addMoviePage from "../pages/addMoviePage.js";
import editMoviePage from "../pages/editMoviePage.js";
import homePage from "../pages/homePage.js";
import loginPage from "../pages/loginPage.js";
import movieDetailsPage from "../pages/movieDetails.js";
import nav from "../pages/nav.js";
import registerPage from "../pages/registerPage.js";
import auth from "./auth.js";

let views = {
    'home': async () => await homePage.getView(),
    'login': async () => await loginPage.getView(),
    'register': async () => await registerPage.getView(),
    'logout': async () => await auth.logout(),
    'movie-details': async (id) => await movieDetailsPage.getView(id),
    'like': async (id) => await movieDetailsPage.like(id),
    'delete': async (id) => await movieDetailsPage.deleteMovie(id),
    'edit': async (id) => await editMoviePage.getView(id),
    'add-movie': async () => await addMoviePage.getView()
}


function setupView(allLinks) {
    allLinks.forEach(e => e.addEventListener('click', changeViewHandler));
}

async function changeViewHandler(e) {
    let element = e.target.matches('.link') ? e.target : e.target.closest('.link');
    let route = element.dataset.route;
    let id = element.dataset.id;
    navigateTo(route, id);
}

async function navigateTo(route, id) {
    if (views.hasOwnProperty(route)) {
        let view = await views[route](id);
        let appElement = document.querySelector('#main');
        appElement.querySelectorAll('.view').forEach(element => element.remove());
        appElement.appendChild(view);
        nav.updateNavigation();
    }
}

async function redirectTo(route) {
    if (views.hasOwnProperty(route)) {
        let viewFunc = views[route]();
        return viewFunc;
    }
}

let viewChanger = {
    setupView,
    navigateTo,
    redirectTo,
    changeViewHandler
}

export default viewChanger;