let yearsSection = document.querySelector('#years');

function hideYearView() {
    yearsSection.style.display = 'none';
}

function showYearView() {
    yearsSection.style.display = 'blcok';
}

export default {
    hideYearView,
    showYearView
}