function solve() {
    let loadbtn = document.querySelector('#btnLoad');
    let createBtn = document.querySelector('#btnCreate');

    loadbtn.addEventListener('click', loadHandler);
    createBtn.addEventListener('click', createHandler);

    let url = 'http://localhost:3030/jsonstore/phonebook';

    function createHandler(e) {
        let personInput = document.querySelector('#person');
        let phoneInput = document.querySelector('#phone');

        let person = personInput.value;
        let phone = phoneInput.value;

        let obj = { person, phone };

        fetch(url, {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        }).then(response => response.json())
            .then(data => alert('Entry is added'))
            .catch(error => alert('Unable to add entry'));

        personInput.value = '';
        phoneInput.value = '';
    }

    //execute Get request and load phones
    function loadHandler(e) {

        let tbody = document.querySelector('#phonebook');
        Array.from(tbody.children).forEach(e => e.remove());

        fetch(url)
            .then(response => response.json())
            .then(data => {
                createElements(data, tbody);
            })
            .catch(error => alert('Unable to load entries'));
    }

    //create load HTML elements
    function createElements(data, tbody) {

        Object.keys(data).forEach(key => {
            let tr = document.createElement('tr');

            let tdName = document.createElement('td');
            tdName.textContent = data[key].person;

            let tdNumber = document.createElement('td');
            tdNumber.textContent = data[key].phone;

            let tdBtn = document.createElement('td');

            let deleteBtn = document.createElement('button');
            deleteBtn.id = key;
            deleteBtn.textContent = 'Delete';
            deleteBtn.addEventListener('click', deleteHandler);

            tdBtn.appendChild(deleteBtn);

            tr.appendChild(tdName);
            tr.appendChild(tdNumber);
            tr.appendChild(tdBtn);

            tbody.appendChild(tr);
        })
    }

    function deleteHandler(e) {

        let trParent = e.target.parentElement.parentElement;
        let id = e.target.id;

        //delete request
        fetch(`${url}/${id}`, {
            method: 'delete'
        })
            .then(response => response.json())
            .catch(error => alert('Unable to delete entry'));
        trParent.remove();

    }


}
solve();
