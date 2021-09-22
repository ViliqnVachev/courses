function colorize() {
    let rowsElements = document.querySelectorAll('table tr');
    let index = 0;
    for (let row of rowsElements) {
        index++;
        if (index % 2 == 0)
            row.style.background = "teal";
    }

}