function create(words) {
   let divContentElement = document.querySelector('#content');
   for (const section of words) {
      let divElement = document.createElement('div');
      let paragraphElement = document.createElement('p');
      paragraphElement.textContent = section;
      paragraphElement.style.display = 'none';
      divElement.appendChild(paragraphElement);
      divElement.addEventListener('click', clickEventHanlder);
      divContentElement.appendChild(divElement);
   }


   function clickEventHanlder(event) {
      event.target.lastChild.style.display = 'block';
   }
}