import httpService from "../utils/httpHelper.js";



let url = 'http://localhost:3030/data/books'

function create(item) {
    let responseData = httpService.jsonRequest(url, 'post', item, true);
    return responseData;
}

function getMyData(userId) {
    let response = httpService.jsonRequest(`${url}?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`)
    return response;

}

function getAll() {
    let responseData = httpService.jsonRequest(`${url}?sortBy=_createdOn%20desc`);
    return responseData;
}

function get(id) {
    let responseData = httpService.jsonRequest(`${url}/${id}`);
    return responseData;
}

function update(id, item) {
    let responseData = httpService.jsonRequest(`${url}/${id}`, 'put', item, true);
    return responseData;
}

function deleteItem(id) {
    if (confirm('Are you sure you want to delte this item')) {
        httpService.jsonRequest(`${url}/${id}`, 'delete', undefined, true, true);
        return true;
    }
    return false

}

let bookService = {
    create,
    getAll,
    get,
    update,
    deleteItem,
    getMyData,

}

export default bookService;