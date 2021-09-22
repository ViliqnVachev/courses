import comments from "./comments.js";
import htmlHelper from "./htmlHelper.js";
import { jsonRequest } from "./httpService.js";

let parentElement = undefined;
let url = 'http://localhost:3030/jsonstore/collections/myboard/posts';

function setupElement(element) {
    parentElement = element;
}

function getView() {
    return parentElement;
}


async function hideView() {
    parentElement.style.display = 'none';
}

async function home() {
    comments.hideComments();
    parentElement.style.display = 'block';
}


async function loadPosts() {

    let result = await jsonRequest(url, undefined, undefined);
    let posts = document.querySelector('div.topic-title');
    Array.from(posts.children).forEach(e => e.remove());
    Object.keys(result).forEach(key => {
        let divTopic = htmlHelper.createElement('div', { class: 'topic-container' });
        let divTopicNameWrap = htmlHelper.createElement('div', { class: 'topic-name-wrapper' });
        let divTopicName = htmlHelper.createElement('div', { class: 'topic-name' });
        let a = htmlHelper.createElement('a', { href: '#', class: 'normal' });
        let h2 = htmlHelper.createElement('h2', undefined, result[key].topicName);
        h2.dataset.id = result[key]._id;
        h2.dataset.user = result[key].username;
        h2.addEventListener('click', comments.showComment);
        let divCol = htmlHelper.createElement('div', { class: 'columns' });
        let div = htmlHelper.createElement('div');
        let p = htmlHelper.createElement('p', undefined, `ID: ${result[key]._id}`);
        let divNick = htmlHelper.createElement('div', { class: 'nick-name' });
        let p2 = htmlHelper.createElement('p', undefined, `Username: `);
        let span = htmlHelper.createElement('span', undefined, result[key].username);

        p2.appendChild(span);
        divNick.appendChild(p2);

        div.appendChild(p);
        div.appendChild(divNick);

        divCol.appendChild(div);
        a.appendChild(h2);
        divTopicName.appendChild(a);
        divTopicName.appendChild(divCol);
        divTopicNameWrap.appendChild(divTopicName);
        divTopic.appendChild(divTopicNameWrap);

        posts.appendChild(divTopic);
    })

}

let homePage = {
    getView,
    setupElement,
    loadPosts,
    hideView,
    home
}

export default homePage;