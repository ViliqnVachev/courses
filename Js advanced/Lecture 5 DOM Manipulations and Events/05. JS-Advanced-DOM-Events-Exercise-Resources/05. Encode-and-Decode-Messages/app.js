function encodeAndDecodeMessages() {
    let buttons = Array.from(document.querySelectorAll('button'));

    let encodeButton = buttons[0];
    let decodeButton = buttons[1];

    encodeButton.addEventListener('click', decode);
    decodeButton.addEventListener('click', encode);

    function decode(event) {
        let message = event.target.parentElement.querySelector('textarea').value;
        let decodedMessage = ''
        for (let index = 0; index < message.length; index++) {
            decodedMessage += String.fromCharCode(message[index].charCodeAt(0) + 1);
        }
        //send to other text area
        event.target.parentElement.parentElement.children[1].querySelector('textArea').value = decodedMessage;
        event.target.parentElement.querySelector('textarea').value = '';
    }
    function encode(event) {
        let message = event.target.parentElement.querySelector('textarea').value;
        let encodeMessage = ''
        for (let index = 0; index < message.length; index++) {
            encodeMessage += String.fromCharCode(message[index].charCodeAt(0) - 1);
        }
        //send to other text area
        event.target.parentElement.querySelector('textarea').value=encodeMessage;
    }
}