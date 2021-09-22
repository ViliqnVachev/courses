import { render } from "../../node_modules/lit-html/lit-html.js";

let viewContainer = undefined;
let nav = undefined;

function init(paramBody, navBody) {
    viewContainer = paramBody;
    nav = navBody;
}

async function renderView(templateResult) {
    render(templateResult, viewContainer);
}
async function renderNavView(templateResult) {
    render(templateResult, nav);
}

function decorateContext(context, next) {
    context.renderView = renderView;
    context.renderNavView = renderNavView;
    next();
}

let renderHelper = {
    renderView,
    init,
    renderNavView,
    decorateContext
}

export default renderHelper;