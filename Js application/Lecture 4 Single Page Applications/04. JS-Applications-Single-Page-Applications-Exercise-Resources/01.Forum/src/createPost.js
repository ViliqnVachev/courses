import { jsonRequest } from "./httpService.js";
import homePage from "./homePage.js";

let url = 'http://localhost:3030/jsonstore/collections/myboard/posts';

function createPostEvents(publicBtn, cancelBtn) {
    cancelBtn.addEventListener('click', cancelHandler);
    publicBtn.addEventListener('click', createPostHandler);
}
function cancelHandler(e) {
    e.preventDefault();
    e.target.parentElement.parentElement.reset();

}

async function createPostHandler(e) {
    e.preventDefault();
    let formData = new FormData(e.target.parentElement.parentElement);
    let topicName = formData.get('topicName');
    let username = formData.get('username');
    let postText = formData.get('postText');

    if (topicName == '' || username == '' | postText == '') {
        alert('Invalid data');
        return;
    }

    let post = {
        topicName,
        username,
        postText
    }

    let result = await jsonRequest(url, 'post', post);
    e.target.parentElement.parentElement.reset();
    let posts = await homePage.loadPosts();

}

export default {
    createPostEvents
}