import page from './node_modules/page/page.mjs'
import createPage from './src/pages/createPage.js';
import dashboardPage from './src/pages/dashboardPage.js'
import detailsPage from './src/pages/detailsPage.js';
import editPage from './src/pages/editPage.js';
import loginPage from './src/pages/loginPage.js';
import logoutPage from './src/pages/logoutPage.js';
import myFurniturePage from './src/pages/myFurniturePage.js';
import navPage from './src/pages/navPage.js';
import registerPage from './src/pages/registerPage.js';
import renderHelper from './src/utils/renderHelper.js';

let navElement = document.querySelector('#navigation');
let viewContainer = document.querySelector('#viewContainer');
renderHelper.init(viewContainer, navElement);

page('/dashboard', renderHelper.decorateContext, navPage.getView, dashboardPage.getView);
page('/login', renderHelper.decorateContext, navPage.getView, loginPage.getView);
page('/register', renderHelper.decorateContext, navPage.getView, registerPage.getView);
page('/logout', renderHelper.decorateContext, navPage.getView, logoutPage.getView);
page('/details/:id', renderHelper.decorateContext, navPage.getView, detailsPage.getView);
page('/create', renderHelper.decorateContext, navPage.getView, createPage.getView);
page('/edit/:id', renderHelper.decorateContext, navPage.getView, editPage.getView);
page('/my-furniture', renderHelper.decorateContext, navPage.getView, myFurniturePage.getView);
page('/index.html', '/dashboard');
page('/', '/dashboard');
page.start();
