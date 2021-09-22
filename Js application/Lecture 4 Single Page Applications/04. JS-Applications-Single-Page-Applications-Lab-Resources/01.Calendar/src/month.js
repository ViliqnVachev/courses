import days from "./days.js";
let monthsPerYear = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'
    , 'Jul', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];
let monthAndYear = '';


let months = Array.from(document.querySelectorAll('.monthCalendar'));

function hideMonths() {
    months.forEach(e => e.style.display = 'none');
}

function showMonth(year) {
    let filterMonths = months.filter(e => e.id.includes(year));
    filterMonths[0].style.display = 'block';
    monthAndYear += year + '-';
    filterMonths[0].addEventListener('click', getMonthHandler);
}

function getMonthHandler(e) {
    if (e.target.classList.contains('date')) {
        let month = e.target.textContent;
        monthAndYear += monthsPerYear.indexOf(month) + 1;
        hideMonths();
        days.showDays(monthAndYear);
    }

}

export default {
    hideMonths,
    showMonth
}