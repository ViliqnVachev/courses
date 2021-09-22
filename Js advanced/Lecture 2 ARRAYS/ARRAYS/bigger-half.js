function solve(params) {
    return params.sort((a, b) => a - b).slice(Math.floor(params.length / 2), params.length)
}

console.log(solve([3, 19, 14, 7, 2, 19, 6]));
