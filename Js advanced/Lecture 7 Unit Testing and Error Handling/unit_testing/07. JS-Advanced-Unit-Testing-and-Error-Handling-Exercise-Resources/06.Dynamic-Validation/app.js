function validate() {
    let inputElement = document.querySelector('#email');
    inputElement.addEventListener('change', checkEmailHandler);

    function checkEmailHandler(event) {
        let email = event.target.value;
        let pattern = /^[a-z]+@[a-z]+.[a-z]+$/;
        if (!pattern.test(email)) {
            event.target.setAttribute('class', 'error');
        } else {
            event.target.setAttribute('class', '');
        }
        console.log(event.target);

    }
}