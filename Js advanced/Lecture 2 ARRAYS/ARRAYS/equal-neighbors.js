function solve(params) {
    let count = 0;
    for (let row = 0; row < params.length; row++) {
        let arr = params[row];
        for (let col = 0; col < arr.length; col++) {

            let element = String(arr[col]);
            //at the same row
            if (String(arr[col + 1]) === element) {
                count++;
            }
            //at the next row
            if (row + 1 < params.length) {
                let nextRowElement = String(params[row + 1][col]);
                if (nextRowElement === element) {
                    count++;
                }
            }
        }
    }
    return count;
}
console.log(solve([
    [2, 2, 5, 7, 4],
    [4, 0, 5, 3, 4],
    [2, 5, 5, 4, 2]]

)
);