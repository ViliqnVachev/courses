import { render } from "./node_modules/lit-html/lit-html.js";
import townsTemplates from "./templates/townTemplate.js";
import { towns } from "./towns.js";

let rootContainer = document.querySelector('#towns');
let btnSearch = document.querySelector('#search');
let resultDiv = document.querySelector('#result');
let allTowns = towns.map(town => ({ name: town }));

render(townsTemplates.allTownsTemplate(allTowns), rootContainer);

btnSearch.addEventListener('click', searchHandler);

function searchHandler(e) {
   let searchInput = document.querySelector('#searchText');
   let searchText = searchInput.value.toLowerCase();
   let currentTowns = towns.map(town => ({ name: town }));
   let matches = currentTowns.filter(town => town.name.toLowerCase().includes(searchText))
      .map(town => town.class = 'active');
   let matchesSize = matches.length

   render(townsTemplates.allTownsTemplate(currentTowns), rootContainer);
   render(townsTemplates.matchesTemplate(matchesSize),resultDiv);

}