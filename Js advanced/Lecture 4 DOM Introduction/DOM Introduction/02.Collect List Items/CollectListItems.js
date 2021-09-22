function extractText() {
    //get li elements
    let liElements = document.querySelectorAll('#items li');
    let textAreaElement = document.querySelector('#result');
    let result;
    for (const data of liElements) {
        result += data.textContent + '\n';
    }
    textAreaElement.textContent = result;
}