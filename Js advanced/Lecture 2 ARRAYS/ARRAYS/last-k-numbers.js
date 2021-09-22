function solve(n, k) {
    let result = [1];
    for (let i = 0; i < n - 1; i++) {
        let nextNumber = 0;
        for (let j = 1; j <= k; j++) {
            if (result[result.length - j] != undefined) {
                nextNumber += Number(result[result.length - j]);
            }
        }
        result.push(nextNumber);
    }
    console.log(result);
}
solve(8, 2)