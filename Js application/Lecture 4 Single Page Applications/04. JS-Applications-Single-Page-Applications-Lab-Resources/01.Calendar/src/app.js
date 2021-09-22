import daysPage from './days.js';
import monthsPage from './month.js';
import yearPage from './year.js';

let years = Array.from(document.querySelectorAll('#years div.date'));

yearPage.showYearView();
monthsPage.hideMonths();
daysPage.hideDays();

years.forEach(year => year.addEventListener('click', getYearHandler));

function getYearHandler(e) {
    let year = e.target.textContent;
    yearPage.hideYearView();
    monthsPage.showMonth(year);
}