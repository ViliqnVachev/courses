function solve(params) {
    let maxNumber = Number.MIN_SAFE_INTEGER;
    params.forEach(element => {
        let max = Math.max(...element);
        if (max > maxNumber) {
            maxNumber = max;
        }
    });
    return maxNumber;
}

console.log(
    solve(
        [[20, 50, 10],
        [8, 33, 145]]
    ));