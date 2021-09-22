function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {
      // get table elements as array
      let tableElements = Array.from(document.querySelectorAll('.container tbody tr'));

      let searchText = document.querySelector('#searchField').value.toLowerCase();
      // celan previus search
      //tr elemetns
      tableElements.forEach(e => e.className = '');
      // fill the search
      for (let tr of tableElements) {
         let tdElemets = Array.from(tr.children);
         let hasMatch = false;
         for (let td of tdElemets) {
            if (td.textContent.toLowerCase().includes(searchText)) {
               hasMatch = true;
            }
         }
         if (hasMatch) {
            tr.className = 'select';
         }
      }
      document.querySelector('#searchField').value = '';
   }

}