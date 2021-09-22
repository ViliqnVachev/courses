import createPost from "./createPost.js";
import homePage from "./homePage.js";



function setup() {
    let homePageElement = document.querySelector('main');
    let publicForm = document.querySelector('#publicForm');
    let cancelBtn = publicForm.querySelector('button.cancel');
    let publicBtn = publicForm.querySelector('button.public');
    let homeBtn = document.querySelector('nav ul li a');

    homePage.setupElement(homePageElement);
    createPost.createPostEvents(publicBtn, cancelBtn);
    homePage.loadPosts();
    homeBtn.addEventListener('click', homePage.home);

}

setup();
