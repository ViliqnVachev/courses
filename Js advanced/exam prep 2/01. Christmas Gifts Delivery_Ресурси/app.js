function solution() {
    //get button element and add event listener
    let buttonAdd = document.querySelector('.card button');
    buttonAdd.addEventListener('click', addGiftEventHandler);
    let gifts = [];

    function addGiftEventHandler(e) {
        // get input
        let inputGift = document.querySelector('.card input');

        // create colection with gifts and order it
        gifts.push(inputGift.value);
        gifts.sort((a, b) => a.localeCompare(b));

        //clear the input
        inputGift.value = '';

        // get ul element
        let ulElement = document.querySelector('.card ul');
        createLiElemets(gifts, ulElement);

    }

    function createLiElemets(gifts, ulElement) {

        //clear the ul
        ulElement.innerHTML = '';

        for (const gift of gifts) {
            // create html
            let li = createLiElement(gift);
            let sendButton = document.createElement('button');
            sendButton.textContent = 'Send';
            sendButton.addEventListener('click', sendEventHandler);
            sendButton.setAttribute('id', 'sendButton');

            let discardButton = document.createElement('button');
            discardButton.textContent = 'Discard';
            discardButton.addEventListener('click', discardEventHandler);
            discardButton.setAttribute('id', 'discardButton');

            li.appendChild(sendButton);
            li.appendChild(discardButton);
            ulElement.appendChild(li);
        }

    }

    function createLiElement(text) {
        let li = document.createElement('li');
        li.textContent = text;
        li.setAttribute('class', 'gift');
        return li;
    }

    function sendEventHandler(e) {
        //get gift
        let currentGift = e.target.parentElement;
        //save it
        let sendLiElement = createLiElement(currentGift.childNodes[0].textContent);

        //remove it from collection and html
        let index = gifts.indexOf(currentGift.childNodes[0].textContent);
        gifts.splice(index, 1);
        currentGift.remove();

        //move to new section
        let sectionSent = document.querySelectorAll('.card')[2];
        let ulSend = sectionSent.querySelector('ul');
        ulSend.appendChild(sendLiElement);


    }

    function discardEventHandler(e) {
        //get gift
        let currentGift = e.target.parentElement;
        //save it
        let sendLiElement = createLiElement(currentGift.childNodes[0].textContent);

        //remove it from collection and html
        let index = gifts.indexOf(currentGift.childNodes[0].textContent);
        gifts.splice(index, 1);
        currentGift.remove();

        //move to new section
        let sectionSent = document.querySelectorAll('.card')[3];
        let ulSend = sectionSent.querySelector('ul');
        ulSend.appendChild(sendLiElement);

    }

}