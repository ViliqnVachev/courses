window.addEventListener('load', solution);

function solution() {
  //get btn and ad event
  let submitBtn = document.querySelector('#submitBTN');
  submitBtn.addEventListener('click', submitEventHandler);

  function submitEventHandler(e) {
    // get inputs
    let fullNameInput = document.querySelector('#fname');
    let emailInput = document.querySelector('#email');
    let phoneInput = document.querySelector('#phone');
    let addressInput = document.querySelector('#address');
    let postCodeInput = document.querySelector('#code');

    //validate data
    if (fullNameInput.value === '' || fullNameInput.value === undefined || emailInput.value === '' || emailInput.value === undefined) {
      return;
    }

    let ulElement = document.querySelector('#infoPreview');


    // append new data
    let fullNameLi = createLiElement('Full Name: ', fullNameInput.value);
    let emailLi = createLiElement('Email: ', emailInput.value);
    let phoneLi = createLiElement('Phone Number: ', phoneInput.value);
    let addressLi = createLiElement('Address: ', addressInput.value);
    let postCodeLi = createLiElement('Postal Code: ', postCodeInput.value);

    ulElement.appendChild(fullNameLi);
    ulElement.appendChild(emailLi);
    ulElement.appendChild(phoneLi);
    ulElement.appendChild(addressLi);
    ulElement.appendChild(postCodeLi);

    //clear the data
    // disable the submit btn
    submitBtn.disabled = true;
    fullNameInput.value = '';
    emailInput.value = '';
    phoneInput.value = '';
    addressInput.value = '';
    postCodeInput.value = '';


    //enablet edit and cont btn
    //get edit and cont btn
    let editBtn = document.querySelector('#editBTN');
    let contBtn = document.querySelector('#continueBTN');
    editBtn.disabled = false;
    contBtn.disabled = false;

    //add event on btns
    editBtn.addEventListener('click', editEventHandler);
    contBtn.addEventListener('click', contEventHandler);



  }

  function editEventHandler(e) {
    //get ul Element
    let liElements = Array.from(document.querySelectorAll('#infoPreview li'));

    // get inputs
    let fullNameInput = document.querySelector('#fname');
    let emailInput = document.querySelector('#email');
    let phoneInput = document.querySelector('#phone');
    let addressInput = document.querySelector('#address');
    let postCodeInput = document.querySelector('#code');

    fullNameInput.value = liElements[0].textContent.split(': ')[1];
    emailInput.value = liElements[1].textContent.split(': ')[1];
    phoneInput.value = liElements[2].textContent.split(': ')[1];
    addressInput.value = liElements[3].textContent.split(': ')[1];
    postCodeInput.value = liElements[4].textContent.split(': ')[1];
    //remove elements
    for (const li of liElements) {
      li.remove();
    }

    // disable and enable btns
    e.target.disabled = true;
    let contBtn = document.querySelector('#continueBTN');
    contBtn.disabled = true;
    submitBtn.disabled = false;

  }

  function contEventHandler(e) {
    // remove all content in block
    let div = document.querySelector('#block');
    div.innerHTML = '';
    //for (const element of divChildrens) {
    //  element.remove();
    //}

    let h3Element = document.createElement('h3');
    h3Element.textContent = 'Thank you for your reservation!';
    div.appendChild(h3Element);


  }

  function createLiElement(prefix, val) {
    let liElement = document.createElement('li');
    liElement.textContent = prefix + val;
    return liElement;
  }
}
