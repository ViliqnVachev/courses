import { notification } from "../templates/notificationTemplate.js";
import { render } from "../node_modules/lit-html/lit-html.js";
let notificationSection = document.querySelector('#notifications');

export function notificationRender(message) {
    render(notification(message), notificationSection);
    setTimeout(() => render(null, notificationSection), 3000);
}