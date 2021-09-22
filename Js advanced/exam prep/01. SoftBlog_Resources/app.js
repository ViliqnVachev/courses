function solve() {
   let btnCreate = document.querySelector('.btn.create');

   btnCreate.addEventListener('click', createEvenetHandler);


   function createEvenetHandler(e) {
      e.preventDefault();
      let sectionElement = document.querySelector('.site-content section');
      let titleInput = document.querySelector('#title');
      let creatorInput = document.querySelector('#creator');
      let categoryInput = document.querySelector('#category');
      let contentInput = document.querySelector('#content');

      let articleElement = document.createElement('article');
      let hElement = document.createElement('h1');
      let pElement = document.createElement('p');
      let pCreatorElement = document.createElement('p');
      let strongCreatorElement = document.createElement('strong');
      let strongElement = document.createElement('strong');
      let pContentElement = document.createElement('p');
      let divElement = document.createElement('div');
      let btnDeleteElement = document.createElement('button');
      let btnArchiveElement = document.createElement('button');

      //set text and attributes to elements
      hElement.textContent = titleInput.value;
      pElement.textContent = 'Category: ';
      strongElement.textContent = categoryInput.value;
      pCreatorElement.textContent = 'Creator: ';
      strongCreatorElement.textContent = creatorInput.value;
      pContentElement.textContent = contentInput.value;
      btnDeleteElement.textContent = 'Delete';
      btnDeleteElement.classList.add( 'btn', 'delete')
      btnDeleteElement.addEventListener('click', deleteEventHandler);
      btnArchiveElement.textContent = 'Archive';
      btnArchiveElement.classList.add( 'btn', 'archive')
      btnArchiveElement.addEventListener('click', archiveEventHandler);
      divElement.setAttribute('class', 'buttons')

      //create html elements structure
      divElement.appendChild(btnDeleteElement);
      divElement.appendChild(btnArchiveElement);
      pElement.appendChild(strongElement);
      pCreatorElement.appendChild(strongCreatorElement);

      articleElement.appendChild(hElement);
      articleElement.appendChild(pElement);
      articleElement.appendChild(pCreatorElement);
      articleElement.appendChild(pContentElement);
      articleElement.appendChild(divElement);
      sectionElement.appendChild(articleElement);

      titleInput.value = '';
      creatorInput.value = '';
      categoryInput.value = '';
      contentInput.value = '';
   }

   function deleteEventHandler(e) {
      e.target.parentElement.parentElement.remove();
   }

   function archiveEventHandler(e) {
      let title = e.target.parentElement.parentElement.querySelector('h1').textContent;
      
      let archiveSection = document.querySelector('.archive-section');
      let olElement = document.querySelector('.archive-section ol');
      let liElement = document.createElement('li');
      liElement.textContent = title;
      olElement.appendChild(liElement);
      let liContentElements = Array.from(olElement.children).map(e => e.textContent).sort((a, b) => a.localeCompare(b));
      olElement.innerHTML='';
     // let newOlElement = document.createElement('ol');
      for (const li of liContentElements) {
         let newLiElement = document.createElement('li');
         newLiElement.textContent = li;
         olElement.appendChild(newLiElement);
      }
      //archiveSection.appendChild(newOlElement);
      e.target.parentElement.parentElement.remove();
   }
}
