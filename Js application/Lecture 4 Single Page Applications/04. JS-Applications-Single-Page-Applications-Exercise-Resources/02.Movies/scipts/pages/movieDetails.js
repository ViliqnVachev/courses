import auth from "../utils/auth.js";
import htmlHelper from "../utils/htmlCreator.js";
import httpService from "../utils/httpService.js";
import viewChanger from "../utils/viewChangers.js";
import editMoviePage from "./editMoviePage.js";
import homePage from "./homePage.js";
let url = 'http://localhost:3030/data/movies';

let section = undefined;

function sectionSetup(element) {
    section = element
}

async function getView(id) {
    let movie = await httpService.jsonRequest(`${url}/${id}`);
    let containerDetails = section.querySelector('.container');
    let userId = auth.getUserId();
    let likes = await httpService.jsonRequest(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22&distinct=_ownerId&count`);
    let userLikes = await httpService.jsonRequest(`http://localhost:3030/data/likes?where=movieId%3D%22${id}%22%20and%20_ownerId%3D%22${userId}%22`);
    Array.from(containerDetails.children).forEach(e => e.remove());
    containerDetails.appendChild(createHTMLMovieDetails(movie, userLikes.length > 0, likes));
    return section;
}

async function like(movieId) {
    let movie = await httpService.jsonRequest(`${url}/${movieId}`);
    let body = {
        movieId: movieId
    }

    let like = await httpService.jsonRequest(`http://localhost:3030/data/likes`, 'post', body, true);
    return getView(movieId);

}

async function deleteMovie(id) {
    let deletedMovie = await httpService.jsonRequest(`http://localhost:3030/data/movies/${id}`, 'delete', undefined, true);
    return homePage.getView();

}

function createHTMLMovieDetails(movie, hasLiked, likes) {
    let divRow = htmlHelper.createElement('div', { class: 'row bg-light text-dark' });
    let h1 = htmlHelper.createElement('h1', undefined, `Movie title: ${movie.title}`);
    let divCol = htmlHelper.createElement('div', { class: 'col-md-8' });
    let img = htmlHelper.createElement('img', { class: 'img-thumbnail', src: `${movie.img}` });
    let divCol4 = htmlHelper.createElement('div', { class: 'col-md-4 text-center' });
    let h3 = htmlHelper.createElement('h3', { class: 'my-3' }, 'Movie Description');
    let p = htmlHelper.createElement('p', undefined, movie.description);

    let deleteA = htmlHelper.createElement('a', { class: 'btn btn-danger link', 'data-route': 'delete', 'data-id': `${movie._id}`, href: '#' }, 'Delete');
    deleteA.addEventListener('click', viewChanger.changeViewHandler);

    let editA = htmlHelper.createElement('a', { class: 'btn btn-warning link', 'data-route': 'edit', 'data-id': `${movie._id}`, href: '#' }, 'Edit');
    editA.addEventListener('click', viewChanger.changeViewHandler);

    let likeA = htmlHelper.createElement('a', { class: 'btn btn-primary link', 'data-route': 'like', 'data-id': `${movie._id}`, href: '#' }, 'Like');
    likeA.addEventListener('click', viewChanger.changeViewHandler);

    let isOwner = movie._ownerId === auth.getUserId();

    if (isOwner || hasLiked) {
        likeA.setAttribute('class', 'hidden');
    }
    if (!isOwner) {
        editA.setAttribute('class', 'hidden');
        deleteA.setAttribute('class', 'hidden');
    }

    let span = htmlHelper.createElement('span', { class: 'enrolled-span' }, `Liked ${likes}`);

    divCol4.appendChild(h3);
    divCol4.appendChild(p);
    divCol4.appendChild(deleteA);
    divCol4.appendChild(editA);
    divCol4.appendChild(likeA);
    divCol4.appendChild(span);
    divCol.appendChild(img);

    divRow.appendChild(h1);
    divRow.appendChild(divCol);
    divRow.appendChild(divCol4);

    return divRow;
}

let movieDetailsPage = {
    sectionSetup,
    getView,
    like,
    deleteMovie
}

export default movieDetailsPage;