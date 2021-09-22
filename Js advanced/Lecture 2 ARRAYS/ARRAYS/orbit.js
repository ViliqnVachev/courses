function solve(params) {
    let rows = params.shift();
    let cols = params.shift();

    let starRow = params.shift();
    let starCol = params.shift();

    let matrix = [];

    for (let row = 0; row < rows; row++) {
        matrix.push([]);
    }

    for (let row = 0; row < rows; row++) {
        for (let col = 0; col < cols; col++) {
            matrix[row][col] = Math.max(Math.abs(row - starRow), Math.abs(col - starCol)) + 1;
        }
    }

    matrix.forEach(row => console.log(row.join(' ')));
}

solve(
    [5, 5, 2, 2]
);