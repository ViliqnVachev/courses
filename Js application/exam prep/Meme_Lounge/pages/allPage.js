import memeService from "../services/memeService.js";
import allMemesTempates from "../templates/allMemesTemplate.js";


async function getView(context) {
    let memes = await memeService.getAll();
    let templateResult = allMemesTempates.allMemesTemplate(memes);
    context.renderView(templateResult);
}


let allPage = {
    getView
}

export default allPage;