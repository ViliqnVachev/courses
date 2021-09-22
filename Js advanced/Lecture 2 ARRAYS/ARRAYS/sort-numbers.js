function solve(params) {
    let result = [];
    params.sort((a, b) => a - b);
    let mid = Math.ceil(params.length / 2);
    let firstHalf = params.slice(0, mid);
    let secondHalf = params.slice(mid, params.lenght);
    for (let i = 0; i <= mid; i++) {
        result.push(firstHalf[i]);
        result.push(secondHalf[secondHalf.length - 1 - i]);
    }
    return result.filter(e => e != undefined);
}

console.log(solve(
    [1, 65, 3, 52, 48, 63, 31, -3, 18]
));