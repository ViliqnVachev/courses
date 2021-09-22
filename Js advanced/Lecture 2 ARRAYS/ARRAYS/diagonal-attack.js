function solve(matrix) {
    matrix = matrix.map(row => row.split(' ').map(element => Number(element)));
    let first = [];
    let second = [];
    for (let row = 0; row < matrix.length; row++) {
        first.push(Number(matrix[row][row]));
        second.push(Number(matrix[row][matrix[row].length - 1 - row]));
    }

    if (first.reduce((acc, x) => acc + x) === second.reduce((acc, x) => acc + x)) {
        let sum = first.reduce((acc, x) => acc + x);
        for (let row = 0; row < matrix.length; row++) {
            for (let col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = sum;
            }
        }
        for (let row = 0; row < matrix.length; row++) {
            matrix[row][row] = first[row];
            matrix[row][matrix[row].length - 1 - row] = second[row];
        }
    }

    return matrix.forEach(element => console.log(element.join(' ')));
}

console.log(solve(
    ['1 1 1',
        '1 1 1',
        '1 1 0']


));