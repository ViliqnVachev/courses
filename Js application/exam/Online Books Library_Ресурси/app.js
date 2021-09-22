import page from './node_modules/page/page.mjs'
import createPage from './pages/createPage.js';
import dashboardPage from './pages/dashboardPage.js';
import deletePage from './pages/deletePage.js';
import detailsPage from './pages/detailsPage.js';
import editPage from './pages/editPage.js';
import likePage from './pages/likePage.js';
import loginPage from './pages/loginPage.js';
import logoutPage from './pages/logoutPage.js';
import myBooksPage from './pages/myBooksPage.js';
import navPage from './pages/navPage.js';
import registerPage from './pages/registerPage.js';
import renderHelper from './utils/renderHelper.js';

let navElement = document.querySelector('#site-header');
let viewContainer = document.querySelector('#site-content');
renderHelper.init(viewContainer, navElement);

page('/index.html', '/dashboard');
page('/', '/dashboard');
page('/home', '/dashboard');
page('/dashboard', renderHelper.decorateContext, navPage.getView, dashboardPage.getView);
page('/login', renderHelper.decorateContext, navPage.getView, loginPage.getView);
page('/register', renderHelper.decorateContext, navPage.getView, registerPage.getView);
page('/logout', renderHelper.decorateContext, navPage.getView, logoutPage.getView);
page('/create', renderHelper.decorateContext, navPage.getView, createPage.getView);
page('/details/:id', renderHelper.decorateContext, navPage.getView, detailsPage.getView);
page('/delete/:id', renderHelper.decorateContext, navPage.getView, deletePage.getView);
page('/edit/:id', renderHelper.decorateContext, navPage.getView, editPage.getView);
page('/myBooks', renderHelper.decorateContext, navPage.getView, myBooksPage.getView);
page('/like/:id', renderHelper.decorateContext, navPage.getView, likePage.getView);

page.start();