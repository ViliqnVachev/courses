import homePage from "./homePage.js"
import htmlHelper from "./htmlHelper.js";
import { jsonRequest } from "./httpService.js";
let mainContainer = document.querySelector('div.container');
let url = 'http://localhost:3030/jsonstore/collections/myboard/posts';
let postID = undefined;

async function showComment(e) {
    homePage.hideView();
    let load = await loadPost(e.target.dataset.id);
    let comments = await loadComments();
    let create = await createPostForm();
    mainContainer.style.display = 'block';

}

async function loadPost(id) {
    postID = id;

    let response = await jsonRequest(`${url}/${id}`, undefined, undefined);

    let divTheme = htmlHelper.createElement('div', { class: 'theme-content' });
    let divTitle = htmlHelper.createElement('div', { class: 'theme-title' });
    let divNameWrap = htmlHelper.createElement('div', { class: 'theme-name-wrapper' });
    let divName = htmlHelper.createElement('div', { class: 'theme-name' });
    let h2 = htmlHelper.createElement('h2', undefined, `${response.topicName}`);

    divName.appendChild(h2);
    divNameWrap.appendChild(divName);
    divTitle.appendChild(divNameWrap);
    divTheme.appendChild(divTitle);
    mainContainer.appendChild(divTheme);

    let divComment = htmlHelper.createElement('div', { class: 'comment' });
    let divHeader = htmlHelper.createElement('div', { class: 'header' });
    let img = htmlHelper.createElement('img', { src: './static/profile.png' });
    let p = htmlHelper.createElement('p', undefined);
    let span = htmlHelper.createElement('span', undefined, `${response.username} posted with id ${id}`);
    p.appendChild(span);

    let pPost = htmlHelper.createElement('p', { class: 'post-content' }, `${response.postText}`);


    divHeader.appendChild(img);
    divHeader.appendChild(p);
    divHeader.appendChild(pPost);
    divComment.appendChild(divHeader);
    mainContainer.appendChild(divComment);

}

async function createPostForm() {
    let divAnswerComment = htmlHelper.createElement('div', { class: 'answer-comment' });
    let p = htmlHelper.createElement('p', undefined, ' comment:');
    let span = htmlHelper.createElement('span', undefined, 'currentUser');
    let divAnswer = htmlHelper.createElement('div', { class: 'answer' });
    let form = htmlHelper.createElement('form');
    let textArea = htmlHelper.createElement('textarea', { name: 'postText', id: 'comment', cols: '30', rows: '10' });
    let div = htmlHelper.createElement('div');
    let label = htmlHelper.createElement('label', { for: 'username' }, 'Username');
    let spanLabel = htmlHelper.createElement('span', { class: 'red' }, '*');
    let input = htmlHelper.createElement('input', { type: 'text', name: 'username', id: 'username' });
    let button = htmlHelper.createElement('button', undefined, 'Post');

    form.addEventListener('submit', createComment)

    label.appendChild(spanLabel);
    div.appendChild(label);
    div.appendChild(input);
    form.appendChild(textArea);
    form.appendChild(div);
    form.appendChild(button);
    divAnswer.appendChild(form);
    p.appendChild(span);

    divAnswerComment.appendChild(p);
    divAnswerComment.appendChild(divAnswer);


    mainContainer.appendChild(divAnswerComment);
}

async function createComment(e) {

    e.preventDefault();
    let formData = new FormData(e.currentTarget);
    let postText = formData.get('postText');
    let userName = formData.get('username');
    let idPost = postID;

    let comment = {
        postText,
        userName,
        _idPost: idPost
    }

    let respose = await jsonRequest('http://localhost:3030/jsonstore/collections/myboard/comments', 'post', comment);
    e.target.reset();

    mainContainer.insertBefore(creaeteCommentHTML(respose), mainContainer.children[3]);

}

async function loadComments() {

    let result = await jsonRequest('http://localhost:3030/jsonstore/collections/myboard/comments', 'get');

    Object.keys(result).forEach(key => {
        if (result[key]._idPost == postID) {
            mainContainer.appendChild(creaeteCommentHTML(result[key]));
        }
    })


}

function creaeteCommentHTML(data) {
    let div = htmlHelper.createElement('div');
    let divTopicNameWrap = htmlHelper.createElement('div', { class: 'topic-name-wraper' });
    let divTopicName = htmlHelper.createElement('div', { class: 'topic-name' });
    let p = htmlHelper.createElement('p', undefined);
    let strong = htmlHelper.createElement('strong', undefined, `${data.userName} commented`);
    let divPost = htmlHelper.createElement('div', { class: 'post-content' });
    let pPost = htmlHelper.createElement('p', undefined, data.postText);

    divPost.appendChild(pPost);
    p.appendChild(strong);
    divTopicName.appendChild(p);
    divTopicName.appendChild(divPost);
    divTopicNameWrap.appendChild(divTopicName);
    div.appendChild(divTopicNameWrap);
    return div;
}

function hideComments() {
    Array.from(mainContainer.children).forEach((element, index) => {
        if (index != 0) {
            element.remove();
        }
    });


}

export default {
    showComment,
    hideComments
}