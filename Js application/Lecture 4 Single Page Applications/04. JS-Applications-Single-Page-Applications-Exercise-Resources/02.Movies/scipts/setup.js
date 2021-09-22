import addMoviePage from "./pages/addMoviePage.js";
import editMoviePage from "./pages/editMoviePage.js";
import homePage from "./pages/homePage.js";
import loginPage from "./pages/loginPage.js";
import movieDetailsPage from "./pages/movieDetails.js";
import nav from "./pages/nav.js";
import registerPage from "./pages/registerPage.js";
import viewChanger from "./utils/viewChangers.js";

async function setup() {
    let appElement = document.querySelector('#main');


    let homeView = document.querySelector('#home-page');
    let loginView = document.querySelector('#form-login');
    let editMovieView = document.querySelector('#edit-movie');
    let registerView = document.querySelector('#form-sign-up');
    let movieDetailsView = document.querySelector('#movie-details');
    let addMovieView = document.querySelector('#add-movie');
    let allLinks = document.querySelectorAll('.link');
    let navEl = document.querySelector("#navigation");

    homePage.sectionSetup(homeView);
    addMoviePage.sectionSetup(addMovieView);
    loginPage.sectionSetup(loginView);
    registerPage.sectionSetup(registerView);
    editMoviePage.sectionSetup(editMovieView);
    movieDetailsPage.sectionSetup(movieDetailsView);
    viewChanger.setupView(allLinks);
    nav.sectionSetup(navEl);
    appElement.querySelectorAll('.view').forEach(element => element.remove());

    let homePageView = await homePage.getView();
    appElement.appendChild(homePageView);

}

setup();