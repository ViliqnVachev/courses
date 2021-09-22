function validate() {
    let submitButton = document.querySelector('#submit');
    submitButton.addEventListener('click', validateHandler);
    let companyCheck = document.querySelector('#company');
    companyCheck.addEventListener('change', changeHandler);

    function validateHandler(e) {
        e.preventDefault();
        let userNameEl = document.querySelector('#username');
        let emailEl = document.querySelector('#email');
        let passwordEl = document.querySelector('#password');
        let confPasswordEL = document.querySelector('#confirm-password');

        let companyNumber = document.querySelector('#companyNumber');
        //validate userName
        let user = /^[a-zA-z0-9]{3,25}$/;
        let isValidUser = user.test(userNameEl.value);
        setBord(userNameEl, isValidUser);
        //validate email
        let email = /.*@.*\..*/
        let isValidEmail = email.test(emailEl.value);
        setBord(emailEl, isValidEmail);

        //validate password
        let password = /^\w{5,15}$/
        let isValidPass = password.test(passwordEl.value);

        let isValidConfPass = passwordEl.value === confPasswordEL.value;
        setBord(passwordEl, isValidConfPass);
        setBord(confPasswordEL, isValidConfPass);

        let isValidNum = false;
        if (companyCheck.checked) {
            let campNmEl = document.querySelector('#companyNumber');

            if (Number(campNmEl.value) == 'number' && Number(campNmEl.value) >= 1000 && Number(campNmEl.value) <= 9999) {
                isValidNum = true;
            }
            setBord(campNmEl, isValidNum);
        }
        let div = document.querySelector('#valid');
        let mainValid = isValidUser && isValidEmail && isValidConfPass ;
        let comp = !companyCheck.checked || (companyCheck.checked && isValidNum);
        let show = mainValid && comp;
        div.style.display = show ? "block" : 'none';
    }

    function setBord(element, isValid) {
        if (isValid) {
            element.style.setProperty('border', 'none');
        } else {
            element.style.setProperty('border', '2px solid red');
        }
    }

    function changeHandler(e) {
        let isChecked = e.currentTarget.checked;
        let fieldset = document.querySelector('#companyInfo');
        isChecked == true ? fieldset.style.display = 'block' : fieldset.style.display = 'none';
    }
}
