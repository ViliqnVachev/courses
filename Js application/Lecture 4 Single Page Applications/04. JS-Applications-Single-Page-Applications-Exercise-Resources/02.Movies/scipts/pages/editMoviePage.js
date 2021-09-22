import httpService from "../utils/httpService.js";
import viewChanger from "../utils/viewChangers.js";
import homePage from "./homePage.js";

let section = undefined;
let url = 'http://localhost:3030/data/movies';
let movieId = undefined;

function sectionSetup(element) {
    section = element
}

async function getView(id) {
    movieId = id;
    let form = section.querySelector('#edit-movie-form');
    fillFormData(form);
    form.addEventListener('submit', editMovieHandler);
    return section;
}

async function editMovieHandler(e) {
    e.preventDefault();

    let formData = new FormData(e.target);
    let title = formData.get('title');
    let description = formData.get('description');
    let img = formData.get('imageUrl');

    let editedMovie = {
        title,
        description,
        img
    }
    let updatedMovie = await httpService.jsonRequest(`${url}/${movieId}`, 'put', editedMovie, true);

    viewChanger.navigateTo('home');

}

async function fillFormData(form) {
    let movieData = await httpService.jsonRequest(`${url}/${movieId}`);

    form.querySelector('input[name="title"]').value = movieData.title;
    form.querySelector('textarea[name="description"]').value = movieData.description;
    form.querySelector('input[name="imageUrl"]').value = movieData.img;

}


let editMoviePage = {
    sectionSetup,
    getView
}

export default editMoviePage;