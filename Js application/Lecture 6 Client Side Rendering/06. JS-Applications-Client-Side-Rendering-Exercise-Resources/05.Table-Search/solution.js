import { render } from "./node_modules/lit-html/lit-html.js";
import tableTemplates from "./templates/tableTemplate.js";

let url = 'http://localhost:3030/jsonstore/advanced/table';
let bodyData = document.querySelector('#load-data');


document.querySelector('#searchBtn').addEventListener('click', searchHandler);

let persons = [];
loadData();

async function loadData() {
   let response = await fetch(url);
   let data = await response.json();
   persons = Object.values(data).map(e => ({
      course: e.course,
      email: e.email,
      fullName: `${e.firstName} ${e.lastName}`,
      _id: e._id
   }))
   render(tableTemplates.tdTemplate(persons), bodyData);

}

function searchHandler(e) {
   let searchInput = document.querySelector('#searchField');
   let searchText = searchInput.value.toLowerCase();
   let allPersons = persons.map(e => Object.assign({}, e));
   allPersons.forEach(person => {
      delete person._id;
   });
   let matches = allPersons.filter(person => Object.values(person).some(e => e.toLowerCase().includes(searchText)));
   matches.forEach(person => person.class = 'select');
   render(tableTemplates.tdTemplate(allPersons), bodyData);
   searchInput.value = '';
}

