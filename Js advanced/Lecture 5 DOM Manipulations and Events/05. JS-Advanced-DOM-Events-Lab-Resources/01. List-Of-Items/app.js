function addItem() {
    //get value
    let ulElement = document.querySelector('#items');
    let inputElement = document.querySelector('#newItemText');
    let inputValue = inputElement.value;

    console.log(inputValue);
    //create a html element
    let newLiElement = document.createElement('li');
    newLiElement.textContent = inputValue;
    //add the element
    ulElement.appendChild(newLiElement);

    // clear the input
    inputElement.value = '';
}