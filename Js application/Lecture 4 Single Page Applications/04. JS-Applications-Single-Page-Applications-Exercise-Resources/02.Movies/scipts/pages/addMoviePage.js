import httpService from "../utils/httpService.js";
import viewChanger from "../utils/viewChangers.js";
import movieDetailsPage from "./movieDetails.js";
let url = 'http://localhost:3030/data/movies'

let section = undefined;

function sectionSetup(element) {
    section = element
}

async function getView() {
    let form = section.querySelector('#addMovieForm');
    form.addEventListener('submit', addMovieHandler)
    return section;
}

async function addMovieHandler(e) {
    e.preventDefault();
    let formData = new FormData(e.target);
    let title = formData.get('title');
    let description = formData.get('description');
    let img = formData.get('imageUrl');

    let movie = {
        title,
        description,
        img
    }

    let result = await httpService.jsonRequest(url, 'post', movie, true);

    e.target.reset();

    viewChanger.navigateTo('movie-details', result._id);

}

let addMoviePage = {
    sectionSetup,
    getView
}

export default addMoviePage;