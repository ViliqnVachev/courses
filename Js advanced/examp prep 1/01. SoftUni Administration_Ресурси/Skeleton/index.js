function solve() {
    let buttonAdd = document.querySelector('.form-control button');

    buttonAdd.addEventListener('click', addEventHandler);

    function addEventHandler(e) {
        e.preventDefault();
        //get all input elements
        let lectureElement = document.querySelector('input[name="lecture-name"]');
        let dateElement = document.querySelector('input[name="lecture-date"]');
        let selectElement = document.querySelector('select[name="lecture-module"]');

        if (lectureElement.value == '' || dateElement.value == '' || selectElement.value == 'Select module') {
            console.log('here');
            return;
        }

        // create training
        //NOTE: check existing module
        let mainModuleDiv = document.querySelector('.modules');
        let modulesDiv = Array.from(document.querySelectorAll('.modules.module h3'));

        //create li element
        let liElement = document.createElement('li');
        liElement.setAttribute('class', 'flex');
        //create h4 element and set text
        let hElement = document.createElement('h4');
        hElement.textContent = `${lectureElement.value} - ${dateElement.value}`;

        //create button
        let deleteBtn = document.createElement('button');
        deleteBtn.textContent = 'Del';
        deleteBtn.setAttribute('class', 'red');
        deleteBtn.addEventListener('click', deleteEventHandler);

        liElement.appendChild(hElement);
        liElement.appendChild(deleteBtn);

        if (modulesDiv.length == 0) {
            //create all elements
            let moduleDivElement = document.createElement('div');
            let moduleHElement = document.createElement('h3');
            let ulElement = document.createElement('ul');

            //edit elements
            moduleDivElement.setAttribute('class', 'module');
            moduleHElement.textContent = selectElement.value;

            //append all elements
            ulElement.appendChild(liElement);
            moduleDivElement.appendChild(moduleHElement);
            moduleDivElement.appendChild(ulElement);
            mainModuleDiv.appendChild(moduleDivElement);

        }


    }

    function deleteEventHandler(e) {
        console.log('here');
    }
};