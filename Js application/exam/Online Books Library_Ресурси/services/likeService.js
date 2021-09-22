import httpService from "../utils/httpHelper.js";

let url = 'http://localhost:3030/data/likes'

async function getLikes(bookId) {
    let likes = await httpService.jsonRequest(`${url}?where=bookId%3D%22${bookId}%22&distinct=_ownerId&count`);
    return likes;
}

async function like(bookId) {
    let body = {
        bookId
    }
    let like = await httpService.jsonRequest(`${url}`, 'post', body, true);
}

async function getLikeFromUser(bookId, userId) {
    let like = await httpService.jsonRequest(`${url}?where=bookId%3D%22${bookId}%22%20and%20_ownerId%3D%22${userId}%22&count`);
    return like;
}


export default {
    getLikes,
    like,
    getLikeFromUser
}