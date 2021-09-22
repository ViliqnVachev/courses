import httpHelper from "../utils/httpHelper.js";
let url = 'http://localhost:3030/jsonstore/collections/books';

async function getAllBooks() {
    let responseResult = await httpHelper.jsonRequest(url)
    return responseResult;
}

async function createBook(book) {
    let responseResult = await httpHelper.jsonRequest(url, 'post', book)
    return responseResult; Ф
}
async function deleteBook(id) {
    let responseResult = await httpHelper.jsonRequest(`${url}/${id}`, 'delete')
    return responseResult; Ф
}

async function getBook(id) {
    let responseResult = await httpHelper.jsonRequest(`${url}/${id}`)
    return responseResult; Ф
}

async function updateBook(id, newBook) {
    let responseResult = await httpHelper.jsonRequest(`${url}/${id}`, 'put', newBook);
    return responseResult; Ф
}


let bookService = {
    getAllBooks,
    createBook,
    deleteBook,
    getBook,
    updateBook
}

export default bookService;