function solve() {

    let btnSubmit = document.querySelector('#submit');
    let btnRefersh = document.querySelector('#refresh');
    btnSubmit.addEventListener('click', submitEventHandler);
    btnRefersh.addEventListener('click', refreshEventHandler);

    function refreshEventHandler(e) {

        let url = 'http://localhost:3030/jsonstore/messenger';

        fetch(url)
            .then(response => response.json())
            .then(data => {
                addDataToHTML(data)
            })

    }

    function addDataToHTML(data) {
        let textArea = document.querySelector('#messages');
        textArea.textContent = '';
        let result = '';
        Object.keys(data).forEach(e => {
            result += `${data[e].author}: ${data[e].content}\n`;
        })

        textArea.textContent = result;

    }

    function submitEventHandler(e) {
        let url = 'http://localhost:3030/jsonstore/messenger';
        let nameInput = document.querySelector('#author');
        let messageInput = document.querySelector('#content');
        let author = nameInput.value;
        let content = messageInput.value;

        let obj = { author, content };

        fetch(url, {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        })
            .then(response => response.json())
            .then(data => alert('Added'))
            .catch(error => alert(error));
        nameInput.value = '';
        messageInput.value = '';
    }
}

solve();