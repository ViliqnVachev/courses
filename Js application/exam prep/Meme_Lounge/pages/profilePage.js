import auth from "../services/authService.js";
import memeService from "../services/memeService.js";
import profileTemplates from "../templates/profileTemplate.js";


async function getView(context) {
    let memes = await memeService.getMyMemes(auth.getUserId());
    let user = {
        userId: auth.getUserId(),
        email: auth.getEmail(),
        gender: auth.getGender(),
        username: auth.getUserName()
    }
    let templateResult = profileTemplates.profileTemplate(memes, user);
    context.renderView(templateResult);
}


let profilePage = {
    getView
}

export default profilePage;