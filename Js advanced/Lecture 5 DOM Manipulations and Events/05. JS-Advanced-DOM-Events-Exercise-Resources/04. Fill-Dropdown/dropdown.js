function addItem() {
    let inputText = document.querySelector('#newItemText').value;
    let inputVal = document.querySelector('#newItemValue').value;

    let option = document.createElement('option');
    option.value = inputVal;
    option.textContent = inputText;
    document.querySelector("#menu").appendChild(option);
    document.querySelector('#newItemText').value = '';
    document.querySelector('#newItemValue').value = '';
}