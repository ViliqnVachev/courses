function solve() {
    //add event and validation of add button
    let addButton = document.querySelector('#add');
    addButton.addEventListener('click', addEventHandler);
    //  addButton

    function addEventHandler(event) {
        event.preventDefault();
        //get input data
        let task = document.querySelector('#task').value;
        let description = document.querySelector('#description').value;
        let date = document.querySelector('#date').value;

        if (task != '' && description != '' && date != '') {
            let articleElement = document.createElement('article');
            let h3Element = document.createElement('h3');
            h3Element.textContent = task;

            let pDesc = document.createElement('p');
            pDesc.textContent = `Description: ${description}`;

            let pDate = document.createElement('p');
            pDate.textContent = `Due Date: ${date}`;

            let divElement = document.createElement('div');
            divElement.setAttribute('class', 'flex');

            let buttonStart = document.createElement('button');
            buttonStart.textContent = 'Start';
            buttonStart.setAttribute('class', 'green');
            buttonStart.addEventListener('click', startTask);

            let buttonDelet = document.createElement('button');
            buttonDelet.textContent = 'Delete';
            buttonDelet.setAttribute('class', 'red');
            buttonDelet.addEventListener('click', deleteTask);

            divElement.appendChild(buttonStart);
            divElement.appendChild(buttonDelet);

            articleElement.appendChild(h3Element);
            articleElement.appendChild(pDesc);
            articleElement.appendChild(pDate);
            articleElement.appendChild(divElement);
            document.querySelector('.orange').parentElement.nextElementSibling.appendChild(articleElement);
            document.querySelector('#task').value = '';
            document.querySelector('#description').value = '';
            document.querySelector('#date').value = '';
        }


    }
    function startTask(event) {
        if (event.target.textContent == 'Start') {
            let finishButton = document.createElement('button');
            finishButton.textContent = 'Finish';
            finishButton.setAttribute('class', 'orange');
            let div = event.target.parentElement;
            div.appendChild(finishButton);
            event.target.remove();

            let copyArticle = div.parentElement.cloneNode(true);
            let buttons = copyArticle.querySelectorAll('button');
            buttons[0].addEventListener('click', deleteTask);
            buttons[1].addEventListener('click', finishTask);
            //remove current
            div.parentElement.remove();

            //add into inprogress
            document.querySelector('#in-progress').appendChild(copyArticle);

        }

    }
    function deleteTask(event) {
        event.target.parentElement.parentElement.remove();
    }

    //add new article to Open section and add buttons
    function finishTask(event) {
        if (event.target.textContent == 'Finish') {
            let article = event.target.parentElement.parentElement.cloneNode(true);
            article.querySelector('div').remove();
            event.target.parentElement.parentElement.remove();
            document.querySelector('.green').parentElement.nextElementSibling.appendChild(article);
        }
    }

}