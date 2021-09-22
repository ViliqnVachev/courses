function solve() {

    let loadBtn = document.querySelector('#loadBooks');
    let submitForm = document.querySelector('.createForm');
    loadBtn.addEventListener('click', loadHandler)
    submitForm.addEventListener('submit', submitHandler);

    let url = 'http://localhost:3030/jsonstore/collections/books';

    function submitHandler(e) {
        e.preventDefault();

        let formData = new FormData(submitForm);
        let title = formData.get('title');
        let author = formData.get('author');

        let obj = { author, title };
        let tbody = document.querySelector('#books');
        fetch(`${url}`, {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        })
            .then(response => {
                if (response.status == 200) {
                    return response.json();
                }
            })
            .then(data => {
                tbody.appendChild(createTbodyHTML(null, data));
            })
        submitForm.reset()
    }

    function loadHandler(e) {
        let tbody = document.querySelector('#books');
        Array.from(tbody.children).forEach(e => e.remove());

        fetch(`${url}`)
            .then(response => response.json())
            .then(data => {
                Object.keys(data).forEach(key => {
                    tbody.appendChild(createTbodyHTML(key, data[key]));
                })

            }).catch(error => alert('Unable to load data'));
    }

    function createTbodyHTML(key, value) {

        let tr = document.createElement('tr');


        let thTitle = document.createElement('th');
        thTitle.textContent = value.title;
        thTitle.classList.add('title');

        let thAuthor = document.createElement('th');
        thAuthor.textContent = value.author;
        thAuthor.classList.add('author');

        let thAction = document.createElement('th');

        let editBtn = document.createElement('button');
        editBtn.textContent = 'Edit';
        editBtn.id = value._id === undefined ? key : value._id;
        editBtn.addEventListener('click', editHandler);

        let deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Delete';
        deleteBtn.id = value._id === undefined ? key : value._id;
        deleteBtn.addEventListener('click', deleteHandler);

        thAction.appendChild(editBtn);
        thAction.appendChild(deleteBtn);

        tr.appendChild(thTitle);
        tr.appendChild(thAuthor);
        tr.appendChild(thAction);

        return tr;

    }

    function editHandler(e) {
        let submitForm = document.querySelector('.createForm');
        let editForm = document.querySelector('.editForm');

        submitForm.style.display = 'none';
        editForm.style.display = 'block';

        let curTitle = e.target.parentElement.parentElement.querySelector('.title').textContent;
        let curAuthor = e.target.parentElement.parentElement.querySelector('.author').textContent;

        let title = document.querySelector('.editForm input[name="title"]');
        let author = document.querySelector('.editForm input[name="author"]');

        editForm.dataset.id = (e.target.id);
        title.value = curTitle
        author.value = curAuthor;
        document.querySelector('#cancelBtn').addEventListener('click', cancelEvent);

        editForm.addEventListener('submit', updateHandler);
    }

    function cancelEvent(e) {
        let submitForm = document.querySelector('.createForm');
        let editForm = document.querySelector('.editForm');
        editForm.style.display = 'none';
        submitForm.style.display = 'block';
    }

    function updateHandler(e) {
        e.preventDefault();

        let id = e.target.dataset.id;

        let formData = new FormData(e.target);

        let title = formData.get('title');
        let author = formData.get('author');
        let obj = { author, title };

        let element = document.querySelector(`button[id="${id}"]`).parentElement.parentElement;

        fetch(`${url}/${id}`, {
            method: 'put',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        }).then(response => response.json())
            .then(data => {
                let editedElement = createTbodyHTML(null, data);
                element.replaceWith(editedElement);
            })
        let submitForm = document.querySelector('.createForm');
        let editForm = document.querySelector('.editForm');

        editForm.style.display = 'none';
        submitForm.style.display = 'block';

    }

    function deleteHandler(e) {

        let id = e.target.id;

        fetch(`${url}/${id}`, {
            method: 'delete'
        }).then(response => alert('Entry is deleted'))
            .catch(error => alert('Unablet to delete entry'))
        e.target.parentElement.parentElement.remove();
    }
}

solve()