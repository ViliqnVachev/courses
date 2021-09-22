function loadCommits() {
    let userName = document.querySelector('#username').value;
    let repo = document.querySelector('#repo').value;
    let url = `https://api.github.com/repos/`;
    let fullUrl = `${url}${userName}/${repo}/commits`;
    let ul = document.querySelector('#commits');

    fetch(fullUrl).then(handleError)
        .then((response) => response.json())
        .then((data) => data.forEach(element => {
            ul.appendChild(createli(element));
        })).catch((error) => console.log(error))


    function handleError(e) {
        if (!e.ok) {
            let li = document.createElement('li');
            li.textContent = `Error: ${e.status} (Not Found)`;
            ul.appendChild(li);
        }

        return e;
    }


    function createli(data) {
        let author = data.commit.author.name;
        let message = data.commit.message;
        let li = document.createElement('li');
        li.textContent = `${author}: ${message}`;
        return li;
    }

}