function attachEvents() {
    let btnPost = document.querySelector('#btnLoadPosts');
    btnPost.addEventListener('click', loadPostHandler);

    let btnView = document.querySelector('#btnViewPost');
    btnView.addEventListener('click', viewEventHandler);

    let baseUrl = 'http://localhost:3030/jsonstore/blog';

    function loadPostHandler(e) {
        let selectPost = document.querySelector('#posts');

        Array.from(selectPost.children).forEach(e => e.remove());

        fetch(`${baseUrl}/posts`)
            .then(response => response.json())
            .then(data => {
                createOptionElement(data);
            }).catch(error => console.log(error))

    }

    function viewEventHandler(e) {
        let postCommentsUl = document.querySelector('#post-comments');
        let postBodyElement = document.querySelector('#post-body');
        Array.from(postCommentsUl.children).forEach(e => e.remove());
        Array.from(postBodyElement.children).forEach(e => e.remove());

        fetch(`${baseUrl}/comments`)
            .then(response => response.json())
            .then(data => {
                let selectPost = document.querySelector('#posts');
                let postId = selectPost.value;
                createCommentHTML(data, postId);
            }).catch(error => console.log(error))

    }

    function createCommentHTML(data, postId) {

        fetch(`${baseUrl}/posts/${postId}`)
            .then(response => response.json())
            .then(data => {
                createPostBody(data)
            }).catch(error => console.log(error))


        let postCommentsUl = document.querySelector('#post-comments');

        for (const key in data) {
            if (data[key].postId === postId) {
                let li = document.createElement('li');
                li.id = data[key].id;
                li.textContent = data[key].text;
                postCommentsUl.appendChild(li);
            }
        }

    }

    function createPostBody(data) {
        let postBodyElement = document.querySelector('#post-body');
        let h1 = document.createElement('h1');
        h1.id = 'post-title';
        h1.textContent = data.title;

        let p = document.createElement('p');
        p.id = 'post-body';
        p.textContent = data.body;

        postBodyElement.appendChild(h1);
        postBodyElement.appendChild(p);
    }

    function createOptionElement(data) {
        let selectPost = document.querySelector('#posts');

        for (const key in data) {

            let option = document.createElement('option');
            option.textContent = data[key].title;
            option.value = data[key].id;
            selectPost.appendChild(option);


        }
    }
}
attachEvents();