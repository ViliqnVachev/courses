import { render } from "./node_modules/lit-html/lit-html.js";
import bookService from "./services/bookServices.js";
import bookTemplates from "./templates/bookTemplate.js";
import btnTemplates from "./templates/buttonTemplate.js";
import formTemplates from "./templates/formTemplate.js";
import httpHelper from "./utils/httpHelper.js";

let loadSection = document.querySelector('#load-section');
let tableSection = document.querySelector('#table-section');
let formSection = document.querySelector('#form-section');
let books = {};
let submitForm = {
    submitHandler
}
let editForm = {
    class: 'hidden',
    editHandler
}

render(btnTemplates.loadBtnTemplate(loadEventHandler), loadSection);
render(bookTemplates.tableTemplate(), tableSection);
render(formTemplates.formTemplate(submitForm, editForm), formSection);


async function loadEventHandler(е) {
    let booksResult = await bookService.getAllBooks();
    let tableBody = document.querySelector('#books');
    console.log(booksResult);
    Object.entries(booksResult).map(e => {
        e[1]._id = e[0];
        if (!books.hasOwnProperty(e[1])) {
            books[e[0]] = e[1];
        }

    });

    render(bookTemplates.bookTemplate(Object.values(books), editBtnHandler, deleteHandler), tableBody);

}
async function submitHandler(e) {
    e.preventDefault();
    let tableBody = document.querySelector('#books');
    let formData = new FormData(e.target);
    let newBook = {
        author: formData.get('author'),
        title: formData.get('title')
    }

    let responseData = await bookService.createBook(newBook);

    if (!books.hasOwnProperty(responseData._id)) {
        books[responseData._id] = responseData;
    }
    render(bookTemplates.bookTemplate(Object.values(books), editBtnHandler, deleteHandler), tableBody);
    e.target.reset();

}
async function editHandler(e) {
    let tableBody = document.querySelector('#books');
    e.preventDefault()
    let bookId = e.currentTarget.querySelector('#book-id').value;
    let formData = new FormData(e.target);
    let updatedBook = {
        author: formData.get('author'),
        title: formData.get('title')
    }
    let responseData = await bookService.updateBook(bookId, updatedBook);

    books[bookId] = responseData;

    e.target.reset();

    editForm.class = 'hidden';
    editForm.author = undefined;
    editForm.title = undefined;
    editForm.id = undefined;
    submitForm.class = undefined;
    render(bookTemplates.bookTemplate(Object.values(books), editBtnHandler, deleteHandler), tableBody);
    render(formTemplates.formTemplate(submitForm, editForm), formSection);
}

async function deleteHandler(e) {
    let tableBody = document.querySelector('#books');
    let bookId = e.target.parentElement.id;
    await bookService.deleteBook(bookId);
    delete books[bookId];
    render(bookTemplates.bookTemplate(Object.values(books), editBtnHandler, deleteHandler), tableBody);

}
async function editBtnHandler(e) {
    let bookId = e.target.parentElement.id;
    let currentBook = await bookService.getBook(bookId);
    editForm.class = undefined;
    editForm.author = currentBook.author;
    editForm.title = currentBook.title;
    editForm.id = currentBook._id;
    submitForm.class = 'hidden';
    render(formTemplates.formTemplate(submitForm, editForm), formSection);

}