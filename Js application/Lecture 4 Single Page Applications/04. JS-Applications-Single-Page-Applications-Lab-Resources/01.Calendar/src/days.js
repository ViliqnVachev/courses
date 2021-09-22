let days = Array.from(document.querySelectorAll('.daysCalendar'));

function hideDays() {
    days.forEach(e => e.style.display = 'none');
}

function showDays(months) {
    let filterdays = days.filter(e => e.id.includes(months));
    filterdays[0].style.display = 'block';
}

export default {
    hideDays,
    showDays
}