function solve() {
    document.querySelector('button').addEventListener('click', onClick);
    let selectElement = document.querySelector('#selectMenuTo');
    let binary = document.createElement('option');
    binary.value = 'binary';
    binary.textContent = 'Binary';
    let hexadecimal = document.createElement('option');
    hexadecimal.value = 'hexadecimal';
    hexadecimal.textContent = 'Hexadecimal';

    selectElement.appendChild(binary);
    selectElement.appendChild(hexadecimal)
    function onClick() {
        let number = Number(document.querySelector('#input').value);
        let result = '';
        if (selectElement.value == 'binary') {
            result = number.toString(2);
        } else {
            result = number.toString(16).toUpperCase();
        }
        document.querySelector('#result').value = result;
    }
}