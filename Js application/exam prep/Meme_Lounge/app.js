import page from './node_modules/page/page.mjs'
import allPage from './pages/allPage.js';
import createPage from './pages/createPage.js';
import detailsPage from './pages/detailsPage.js';
import editPage from './pages/editPage.js';
import homePage from './pages/homePage.js';
import loginPage from './pages/loginPage.js';
import logoutPage from './pages/logoutPage.js';
import navPage from './pages/navPage.js';
import profilePage from './pages/profilePage.js';
import registerPage from './pages/registerPage.js';
import renderHelper from './utils/renderHelper.js';



let navElement = document.querySelector('#navigation');
let viewContainer = document.querySelector('#view');
renderHelper.init(viewContainer, navElement);

page('/home', renderHelper.decorateContext, navPage.getView, homePage.getView);
page('/index.html', '/home');
page('/', '/home');
page('/login', renderHelper.decorateContext, navPage.getView, loginPage.getView);
page('/all', renderHelper.decorateContext, navPage.getView, allPage.getView);
page('/register', renderHelper.decorateContext, navPage.getView, registerPage.getView);
page('/logout', renderHelper.decorateContext, navPage.getView, logoutPage.getView);
page('/create', renderHelper.decorateContext, navPage.getView, createPage.getView);
page('/details/:id', renderHelper.decorateContext, navPage.getView, detailsPage.getView);
page('/edit/:id', renderHelper.decorateContext, navPage.getView, editPage.getView);
page('/profile', renderHelper.decorateContext, navPage.getView, profilePage.getView);
page.start();
