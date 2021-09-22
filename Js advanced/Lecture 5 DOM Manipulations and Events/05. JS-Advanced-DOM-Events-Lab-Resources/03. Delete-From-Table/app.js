function deleteByEmail() {
    //get input value
    let inputValue = document.querySelector('input').value;
    let tdElements = Array.from(document.querySelectorAll('tbody tr td:nth-child(2)'));

    let result = 'Not found.';
    //check for maching
    for (const email of tdElements) {
        if (email.textContent==inputValue) {
            result = 'Deleted';
            //delete if match
            email.parentElement.remove();
        }
    }

    //output
    document.querySelector('#result').textContent = result;
    document.querySelector('input').value = '';
}