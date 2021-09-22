import { html } from "../node_modules/lit-html/lit-html.js";

export function notification(message) {
    return html`
    <!-- Notifications -->
    <div id="errorBox" class="notification">
        <span>${message}</span>
    </div>
    `;
}