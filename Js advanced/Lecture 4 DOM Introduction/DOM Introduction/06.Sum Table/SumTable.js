function sumTable() {
    let rowsElemets = document.querySelectorAll('td:nth-child(2)');
    let rowsArr = Array.from(rowsElemets);
    rowsArr.pop();
    let result = rowsArr.reduce((acc, x) => acc += Number(x.textContent), 0);
    document.querySelector('#sum').textContent = result;

}