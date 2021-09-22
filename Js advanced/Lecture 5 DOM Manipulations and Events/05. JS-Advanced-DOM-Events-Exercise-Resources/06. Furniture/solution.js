function solve() {
  //generate
  let buttons = document.querySelectorAll('button');
  buttons[0].addEventListener('click', generate);
  buttons[1].addEventListener('click', buy);


  function generate(event) {
    let input = document.querySelector('#exercise textarea').value;
    let inputArr = Array.from(JSON.parse(input));
    for (const obj of inputArr) {
      let trElement = document.createElement('tr');
      let tdImageElement = document.createElement('td');
      let imgElement = document.createElement('img');
      imgElement.setAttribute('src', obj.img);
      tdImageElement.appendChild(imgElement);
      trElement.appendChild(tdImageElement);

      let tdNameElement = document.createElement('td');
      let pNameElement = document.createElement('p');
      pNameElement.textContent = obj.name;
      tdNameElement.appendChild(pNameElement);
      trElement.appendChild(tdNameElement);

      let tdPriceElement = document.createElement('td');
      let pPriceElement = document.createElement('p');
      pPriceElement.textContent = obj.price;
      tdPriceElement.appendChild(pPriceElement);
      trElement.appendChild(tdPriceElement);

      let tdDecFactorElement = document.createElement('td');
      let pDecFactorElement = document.createElement('p');
      pDecFactorElement.textContent = obj.decFactor;
      tdDecFactorElement.appendChild(pDecFactorElement);
      trElement.appendChild(tdDecFactorElement);

      let tdCheckBox = document.createElement('td');
      let input = document.createElement('input');
      input.type = 'checkbox';
      tdCheckBox.appendChild(input);
      trElement.appendChild(tdCheckBox);

      document.querySelector('tbody').appendChild(trElement);
    }


  }

  //buy
  function buy(event) {
    //get all checked 
    let bought = [];
    let total = 0;
    let factor = []
    let inputs = Array.from(document.querySelectorAll('input[type="checkbox"]'));
    for (const input of inputs) {
      if (input.checked) {
        bought.push(input.parentElement.parentElement.children[1].textContent.trim());
        total += Number(input.parentElement.parentElement.children[2].textContent.trim());
        factor.push(Number(input.parentElement.parentElement.children[3].textContent.trim()));
      }
    }
    let boghtResult = `Bought furniture: ${bought.join(', ')}\n`;
    let totalPrice = `Total price: ${total.toFixed(2)}\n`;
    let avrg = `Average decoration factor: ${factor.reduce((ac, x) => ac += x, 0) / factor.length}`
    let textarea = event.target.parentElement.querySelectorAll('textarea')[1];
    textarea.value = boghtResult;
    textarea.value += totalPrice;
    textarea.value += avrg;
  }
}


