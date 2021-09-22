import httpService from "../utils/httpHelper.js";

let url = 'http://localhost:3030/data/catalog'

function create(furniture) {
    let responseData = httpService.jsonRequest(url, 'post', furniture, true);
    return responseData;
}

function getAll() {
    let responseData = httpService.jsonRequest(url);
    return responseData;
}

function getMyData(userId) {
    let responseData = httpService.jsonRequest(`${url}?where=_ownerId%3D%22${userId}%22`);
    return responseData;
}

function get(id) {
    let responseData = httpService.jsonRequest(`${url}/${id}`);
    return responseData;
}

function update(id, furniture) {
    let responseData = httpService.jsonRequest(`${url}/${id}`, 'put', furniture, true);
    return responseData;
}

function deleteFurniture(id) {
    let responseData = httpService.jsonRequest(`${url}/${id}`, 'delete', undefined, true, true);

}

let catalogService = {
    create,
    getAll,
    get,
    update,
    deleteFurniture,
    getMyData
}

export default catalogService;