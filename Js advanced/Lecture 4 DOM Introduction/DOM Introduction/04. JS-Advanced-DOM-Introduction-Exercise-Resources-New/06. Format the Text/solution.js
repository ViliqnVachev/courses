function solve() {
  //get text from input
  let textAreaElement = document.querySelector('#input');
  let inputText = textAreaElement.value;

  //split the text
  let textArray = inputText.split('.').filter(e => e != '').map(e => e + '.');

  //create paragraphs  
  let paragraphsNumber = Math.ceil(textArray.length / 3);
  let result = '';
  for (let index = 0; index < paragraphsNumber; index++) {
    document.querySelector('#output').innerHTML +=`<p>${textArray.splice(0, 3).join('')}</p>`
  }
  //fill the result
 // document.querySelector('#output').innerHTML += result;

}