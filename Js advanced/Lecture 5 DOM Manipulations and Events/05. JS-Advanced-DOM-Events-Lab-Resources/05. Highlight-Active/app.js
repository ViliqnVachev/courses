function focused() {
    let inputElements = document.querySelectorAll('input');
    let inputElementsArr = Array.from(inputElements);
    for (const input of inputElementsArr) {
        input.addEventListener('focus', focusEventHandler);
        input.addEventListener('blur', blurEventHandler);
    }

    function focusEventHandler(event) {
        event.currentTarget.parentElement.setAttribute('class', 'focused')
    }
    function blurEventHandler(event) {
        event.currentTarget.parentElement.setAttribute('class', '')
    }
}