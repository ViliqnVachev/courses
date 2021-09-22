function lockedProfile() {
    //attach event    
    let buttonsElements = Array.from(document.querySelectorAll('button'));

    for (let button of buttonsElements) {
        button.addEventListener('click', clickEventHandler);
    }

    function clickEventHandler(event) {
        let radioElement = event.target.parentElement.querySelector('input:checked');
        if (radioElement.value == 'unlock') {
            let buttonText = event.target.textContent;
            let divElement = event.target.previousElementSibling;
            event.target.textContent = buttonText == 'Show more' ? 'Hide it' : 'Show more';
            divElement = buttonText != 'Show more' ? divElement.style.display = 'none' : divElement.style.display = 'inline-block';
        }
    }
}