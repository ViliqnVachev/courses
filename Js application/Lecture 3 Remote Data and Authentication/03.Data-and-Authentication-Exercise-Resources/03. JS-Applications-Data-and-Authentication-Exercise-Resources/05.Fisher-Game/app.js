function solve() {
    let divGuest = document.querySelector('#guest');
    let divUser = document.querySelector('#user');
    let sectionViews = document.querySelector('#views');
    let navElement = document.querySelector('nav');
    let registerForm = document.querySelector('form#register');
    let pWelcome = navElement.querySelector('p.email');
    let loginForm = document.querySelector('form#login');
    let loadBtn = document.querySelector('button.load');
    let logoutBtn = document.querySelector('#logout');
    let addForm = document.querySelector('#addForm');
    let addBtn = document.querySelector('.add');

    if (localStorage.getItem('token') == null) {
        loginView(false)
    } else {
        loginView(true);
    }

    navElement.addEventListener('click', showPages);
    registerForm.addEventListener('submit', registerHandler);
    loginForm.addEventListener('submit', loginHandler);
    loadBtn.addEventListener('click', loadCathes)
    logoutBtn.addEventListener('click', logoutHandler);
    addForm.addEventListener('submit', addCatchHandler)

    function addCatchHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.currentTarget);
        let angler = formData.get('angler');
        let weight = formData.get('weight');
        let species = formData.get('species');
        let location = formData.get('location');
        let bait = formData.get('bait');
        let captureTime = formData.get('captureTime');

        let obj = {
            angler,
            weight: Number(weight),
            species,
            location,
            bait,
            captureTime: Number(captureTime)
        }

        fetch('http://localhost:3030/data/catches', {
            method: 'post',
            headers: {
                'Content-type': 'application/json',
                'X-Authorization': `${localStorage.getItem('token')}`
            },
            body: JSON.stringify(obj)
        })
            .then(res => res.json())
            .then(data => {
                let cathces = document.querySelector('#catches')
                cathces.appendChild(createCatchHTM(data));
            })
            .catch(error => alert('Unable to create element'));
        e.target.reset()
    }

    function logoutHandler(e) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        localStorage.removeItem('userId');
        loginView(false);
        
    }

    function loadCathes() {
        fetch('http://localhost:3030/data/catches')
            .then(res => res.json())
            .then(data => {
                let cathces = document.querySelector('#catches');
                Array.from(cathces.children).forEach(element => element.remove());
                cathces.append(...data.map(e => createCatchHTM(e)))
            })
            .catch(err => alert('Unable to load data'));

    }
    function loginHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.currentTarget);
        let email = formData.get('email');
        let password = formData.get('password');
        let obj = { email, password };
        fetch('http://localhost:3030/users/login', {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        })
            .then(res => res.json())
            .then(data => {
                localStorage.setItem('token', data.accessToken);
                localStorage.setItem('user', data.email);
                localStorage.setItem('userId', data._id);
                loginView(true);
            })
            .catch(err => alert('Unable to log in'));
    }

    function registerHandler(e) {
        e.preventDefault();
        let formData = new FormData(e.currentTarget);
        let email = formData.get('email');
        let password = formData.get('password');
        let rePass = formData.get('rePass');
        if (password !== rePass) {
            alert('Passwords are not equal');
            e.currentTarget.reset();
        } else {
            let obj = { email, password };
            fetch('http://localhost:3030/users/register', {
                method: 'post',
                headers: { 'Content-type': 'application/json' },
                body: JSON.stringify(obj)
            })
                .then(res => res.json())
                .then(data => {
                    localStorage.setItem('token', data.accessToken);
                    localStorage.setItem('user', data.email);
                    localStorage.setItem('userId', data._id);
                    loginView(true);
                })
                .catch(err => alert('Unable to register'))
        }

    }
    function loginView(isLogedIn) {
        if (isLogedIn) {
            divGuest.style.display = 'none';
            divUser.style.display = 'block';
            pWelcome.textContent = `Welcome ${localStorage.getItem('user')}`;
            addBtn.disabled = false;
            showPage('home-view');
            loadCathes();
        } else {
            divGuest.style.display = 'block';
            divUser.style.display = 'none';
            pWelcome.textContent = `Welcome guest`;
            addBtn.disabled = true;
            showPage('home-view');
            loadCathes();
        }

    }
    function showPages(e) {
        if (e.target.id == 'register') {
            showPage('register-view');
        } else if (e.target.id == 'home') {
            showPage('home-view');
        } else if (e.target.id == 'login') {
            showPage('login-view');
        }
    }
    function showPage(id) {
        let pageSections = Array.from(sectionViews.querySelectorAll('section'));
        pageSections.forEach(section => {
            if (section.id == id) {
                section.classList.remove('hidden');
            } else {
                section.classList.add('hidden');
            }

        })

    }

    function createCatchHTM(data) {
        let anglerLable = createElement('label', undefined, 'Angler');
        let anglerInput = createElement('input', { type: 'text', class: 'angler' }, data.angler);
        let hr1 = createElement('hr');
        let weightLable = createElement('label', undefined, 'Weight');
        let weightInput = createElement('input', { type: 'number', class: 'weight' }, data.weight);
        let hr2 = createElement('hr');
        let speciesLable = createElement('label', undefined, 'Species');
        let speciesInput = createElement('input', { type: 'text', class: 'species' }, data.species);
        let hr3 = createElement('hr');
        let locationLable = createElement('label', undefined, 'Location');
        let locationInput = createElement('input', { type: 'text', class: 'location' }, data.location);
        let hr4 = createElement('hr');
        let baitLable = createElement('label', undefined, 'Bait');
        let baitInput = createElement('input', { type: 'text', class: 'bait' }, data.bait);
        let hr5 = createElement('hr');
        let captureTimeLable = createElement('label', undefined, 'Capture');
        let captureTimeInput = createElement('input', { type: 'text', class: 'capture' }, data.captureTime);
        let hr6 = createElement('hr');

        let updateBtn = createElement('button', { disabled: true, class: 'update' }, 'Update');
        updateBtn.disabled = localStorage.getItem('userId') !== data._ownerId;
        updateBtn.addEventListener('click', updateHandler);
        let deleteBtn = createElement('button', { disabled: true, class: 'delete' }, 'Delete');
        deleteBtn.disabled = localStorage.getItem('userId') !== data._ownerId;
        deleteBtn.addEventListener('click', deleteHandler);

        let div = document.createElement('div');
        div.classList.add('catch');

        div.appendChild(anglerLable);
        div.appendChild(anglerInput);
        div.appendChild(hr1);
        div.appendChild(weightLable);
        div.appendChild(weightInput);
        div.appendChild(hr2);
        div.appendChild(speciesLable);
        div.appendChild(speciesInput);
        div.appendChild(hr3);
        div.appendChild(locationLable);
        div.appendChild(locationInput);
        div.appendChild(hr4);
        div.appendChild(baitLable);
        div.appendChild(baitInput);
        div.appendChild(hr5);
        div.appendChild(captureTimeLable);
        div.appendChild(captureTimeInput);
        div.appendChild(hr6);
        div.appendChild(updateBtn);
        div.appendChild(deleteBtn);

        div.dataset.id = data._id;
        div.dataset.ownerId = data._ownerId;

        return div;
    }
    function createElement(tag, attributes, ...params) {
        let elemenet = document.createElement(tag);
        let firstValue = params[0];
        if (params.length === 1 && typeof (firstValue) !== 'object') {
            if (['input', 'textarea'].includes(tag)) {
                elemenet.value = firstValue;
            } else {
                elemenet.textContent = firstValue;
            }

        } else {
            elemenet.append(...params);
        }
        if (attributes !== undefined) {
            Object.keys(attributes).forEach(key => {
                elemenet.setAttribute(key, attributes[key])
            })
        }
        return elemenet;
    }

    function updateHandler(e) {
        let id = e.target.parentElement.dataset.id;
        let curCatch = e.target.parentElement;
        let angler = curCatch.querySelector('.angler').value;
        let weight = curCatch.querySelector('.weight').value;
        let species = curCatch.querySelector('.species').value;
        let location = curCatch.querySelector('.location').value;
        let bait = curCatch.querySelector('.bait').value;
        let captureTime = curCatch.querySelector('.capture').value;

        let obj = {
            angler,
            weight: Number(weight),
            species,
            location,
            bait,
            captureTime: Number(captureTime)
        }

        fetch(`http://localhost:3030/data/catches/${id}`, {
            method: 'put',
            headers: {
                'Content-type': 'application/json',
                'X-Authorization': `${localStorage.getItem('token')}`
            },
            body: JSON.stringify(obj)
        })
            .then(res => res.json())
            .catch(error => alert('Unable to update data'));
    }
    function deleteHandler(e) {
        let id = e.target.parentElement.dataset.id;
        fetch(`http://localhost:3030/data/catches/${id}`, {
            method: 'delete',
            headers: {
                'Content-type': 'application/json',
                'X-Authorization': `${localStorage.getItem('token')}`
            },
        })
            .then(res => res.json())
            .catch(error => alert('Unable to delete data'));

        e.target.parentElement.remove();
    }


}
solve();