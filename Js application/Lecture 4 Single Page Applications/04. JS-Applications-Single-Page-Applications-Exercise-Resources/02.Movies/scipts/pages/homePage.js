import auth from "../utils/auth.js";
import htmlHelper from "../utils/htmlCreator.js";
import httpService from "../utils/httpService.js";
import viewChanger from "../utils/viewChangers.js";
import nav from "./nav.js";
let url = 'http://localhost:3030/data/movies';

let section = undefined;

function sectionSetup(element) {
    section = element
}

async function getView() {
    let movies = await httpService.jsonRequest(url);
    let movieContainer = section.querySelector('#movie-container');
    Array.from(movieContainer.children).forEach(element => element.remove());

    let btnAdd = section.querySelector('#add-movie-button a');
    if (auth.isLoggedIn()) {
        btnAdd.className = 'btn btn-warning link';
        btnAdd.addEventListener('click', viewChanger.changeViewHandler);
    } else {
        btnAdd.className = 'hidden';
    }


    for (const movie of movies) {
        let divMovieCard = await createHTMLMovie(movie);
        movieContainer.appendChild(divMovieCard);
    }

    nav.updateNavigation();

    return section;
}

let homePage = {
    sectionSetup,
    getView
}

async function createHTMLMovie(movie) {

    let divCard = htmlHelper.createElement('div', { class: 'card mb-4' });
    let img = htmlHelper.createElement('img', { class: 'card-img-top', src: `${movie.img}`, alt: 'Card image cap', widdth: '400' });
    let divCardBody = htmlHelper.createElement('div', { class: 'card-body' });
    let h4 = htmlHelper.createElement('h4', { class: 'card-title' }, `${movie.title}`);
    let divFooter = htmlHelper.createElement('div', { class: 'card-footer' });
    let a = htmlHelper.createElement('a', { class: 'link', 'data-route': 'movie-details', 'data-id': `${movie._id}`, href: '#/details/CUtL9j4qI0XVhn9kTUsx' });
    let detailsBtn = htmlHelper.createElement('button', { type: 'button', class: 'btn btn-info' }, `Details`);

    detailsBtn.addEventListener('click', viewChanger.changeViewHandler);

    divCardBody.appendChild(h4);
    a.appendChild(detailsBtn);
    divFooter.appendChild(a)

    divCard.appendChild(img);
    divCard.appendChild(divCardBody);
    divCard.appendChild(divFooter);

    return divCard;
}


export default homePage;