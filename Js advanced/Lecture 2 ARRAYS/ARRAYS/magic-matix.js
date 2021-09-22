function solve(params) {
    let sumRow = row => params[row].reduce((a, b) => a + b);
    let sumCol = col => params.map(row => row[col])
        .reduce((a, b) => a + b);

    if (params.length > 0) {
        let targetSum = sumRow(0);
        for (let i = 1; i < params.length; i++) {
            let rowSum = sumRow(i);
            if (rowSum !== targetSum) {
                return false;
            }
        }
        for (let j = 0; j < params[0].length; j++) {
            let colSum = sumCol(j);
            if (colSum !== targetSum) {
                return false;
            }
        }
    }
    return true;
}

console.log(solve(
    [[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]


));