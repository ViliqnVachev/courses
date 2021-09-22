import page from './node_modules/page/page.mjs'
import allCarsPage from './pages/allCarsPage.js';
import createPage from './pages/createPage.js';
import deletePage from './pages/deletePage.js';
import detailsPage from './pages/detailsPage.js';
import editPage from './pages/editPage.js';
import homePage from './pages/homePage.js';
import loginPage from './pages/loginPage.js';
import logoutPage from './pages/logoutPage.js';
import myCarsPage from './pages/myCarsPage.js';
import navPage from './pages/navPage.js';
import registerPage from './pages/registerPage.js';
import searchPage from './pages/searchPage.js';
import myCarTemplate from './templates/myCarTemplate.js';
import renderHelper from './utils/renderHelper.js';

let navElement = document.querySelector('#navigation');
let viewContainer = document.querySelector('#site-content');
renderHelper.init(viewContainer, navElement);

page('/home', renderHelper.decorateContext, navPage.getView, homePage.getView);
page('/index.html', '/home');
page('/', '/home');
page('/login', renderHelper.decorateContext, navPage.getView, loginPage.getView);
page('/register', renderHelper.decorateContext, navPage.getView, registerPage.getView);
page('/all', renderHelper.decorateContext, navPage.getView, allCarsPage.getView);
page('/logout', renderHelper.decorateContext, navPage.getView, logoutPage.getView);
page('/details/:id', renderHelper.decorateContext, navPage.getView, detailsPage.getView);
page('/delete/:id', renderHelper.decorateContext, navPage.getView, deletePage.getView);
page('/create', renderHelper.decorateContext, navPage.getView, createPage.getView);
page('/myCars', renderHelper.decorateContext, navPage.getView, myCarsPage.getView);
page('/edit/:id', renderHelper.decorateContext, navPage.getView, editPage.getView);
page('/search', renderHelper.decorateContext, navPage.getView, searchPage.getView);
page.start()