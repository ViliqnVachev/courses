import httpService from "../utils/httpHelper.js";



let url = 'http://localhost:3030/data/cars'

function create(item) {
    let responseData = httpService.jsonRequest(url, 'post', item, true);
    return responseData;
}

function getMyData(userId) {
    let response = httpService.jsonRequest(`${url}?where=_ownerId%3D%22${userId}%22&sortBy=_createdOn%20desc`)
    return response;

}

function search(year) {
    let response = httpService.jsonRequest(`${url}?where=year%3D${year}`)
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
    let responseData = httpService.jsonRequest(`${url}/${id}`, 'delete', undefined, true, true);

}

let carService = {
    create,
    getAll,
    get,
    update,
    deleteItem,
    getMyData,
    search
}

export default carService;