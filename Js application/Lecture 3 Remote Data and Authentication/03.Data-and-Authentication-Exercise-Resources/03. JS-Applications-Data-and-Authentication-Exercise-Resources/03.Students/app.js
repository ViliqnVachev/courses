function solve() {
    let url = 'http://localhost:3030/jsonstore/collections/students';
    let form = document.querySelector('#form');
    form.addEventListener('click', submitHandler);

    function submitHandler(e) {
        e.preventDefault();

        let btn = document.querySelector('#submit');
        if (e.target !== btn) {
            return;
        }

        const data = new FormData(form);
        let firstName = data.get('firstName');
        let lastName = data.get('lastName');
        let facultyNumber = data.get('facultyNumber');
        let grade = data.get('grade');

        if (!verifyData(firstName, lastName, facultyNumber, grade)) {
            alert('Invalid data');
            return;
        }
        grade = Number(grade);

        let obj = { firstName, lastName, facultyNumber, grade };

        fetch(`${url}`, {
            method: 'post',
            headers: { 'Content-type': 'application/json' },
            body: JSON.stringify(obj)
        })
            .then(response => {
                //load elements
                fetch(`${url}`)
                    .then(response => response.json())
                    .then(data => {
                        loadElements(data);
                    })
            }).catch(error => alert('Error'));
        form.reset();
    }

    function verifyData(firstName, lastName, facultyNumber, grade) {
        if (firstName === '' || lastName === '' || facultyNumber === '') {
            return false;
        }
        if (isNaN(grade)) {
            return false;
        }

        return true;

    }

    function loadElements(data) {
        let tableBody = document.querySelector('tbody');
        Array.from(tableBody.children).forEach(e => e.remove());

        Object.keys(data).forEach(key => {
            let tr = document.createElement('tr');

            let thFirstName = document.createElement('th');
            thFirstName.textContent = data[key].firstName;

            let thLastName = document.createElement('th');
            thLastName.textContent = data[key].lastName;

            let thfNumber = document.createElement('th');
            thfNumber.textContent = data[key].facultyNumber;

            let thGrade = document.createElement('th');
            thGrade.textContent = data[key].grade;

            tr.appendChild(thFirstName);
            tr.appendChild(thLastName);
            tr.appendChild(thfNumber);
            tr.appendChild(thGrade);

            tableBody.appendChild(tr);
        })
    }

}

solve();