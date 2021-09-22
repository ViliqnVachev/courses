function search() {
   //get all towns
   let townsElements = Array.from(document.querySelector('#towns').children);
   //get searched text
   let searchedText = document.querySelector('#searchText').value.toLowerCase();


   //clear 
   townsElements.forEach(e => {
      e.style.fontWeight = 'normal';
      e.style.textDecoration = 'none';
   })

   //check maches
   let result = townsElements.filter(e => e.textContent.toLowerCase().includes(searchedText));
   result.forEach(e => {
      e.style.fontWeight = 'bold';
      e.style.textDecoration = 'underline';
   })
   //print result
   document.querySelector('#result').textContent = `${result.length} matches found`
}
