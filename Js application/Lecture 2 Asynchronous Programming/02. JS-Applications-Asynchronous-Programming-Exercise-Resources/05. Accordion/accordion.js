function solution() {
    fetch('http://localhost:3030/jsonstore/advanced/articles/list')
        .then(response => response.json())
        .then(data => {
            let section = document.querySelector('#main');
            for (const ent of data) {
                let div = document.createElement('div');
                div.classList.add('accordion');
                div.appendChild(createHeadHTML(ent));
                section.appendChild(div);
            }

        })

    function createHeadHTML(data) {
        let div = document.createElement('div');
        div.classList.add('head');

        let span = document.createElement('span');
        span.textContent = data.title;

        let btn = document.createElement('button');
        btn.classList.add('button');
        btn.id = data._id;
        btn.textContent = 'More';
        btn.addEventListener('click', showMoreEventHandler);

        div.appendChild(span);
        div.appendChild(btn);
        return div;
    }

    function showMoreEventHandler(e) {
        if (e.target.parentElement.nextSibling == null) {
            fetch(`http://localhost:3030/jsonstore/advanced/articles/details/${e.target.id}`)
                .then(response => response.json())
                .then(data => {
                    let div = createExtraHTML(data)
                    e.target.parentElement.parentElement.appendChild(div);
                });
            e.target.textContent = 'Less';
        } else {
            if (e.target.textContent == 'Less') {
                e.target.parentElement.nextSibling.style.display = 'none'
                e.target.textContent = 'More'
            } else {
                e.target.parentElement.nextSibling.style.display = 'block'
                e.target.textContent = 'Less'
            }
        }
    }

    function createExtraHTML(data) {
        let div = document.createElement('div');
        div.classList.add('extra');
        div.style.display = 'block';

        let p = document.createElement('p');
        p.textContent = data.content;

        div.appendChild(p);

        return div;

    }
}

solution()