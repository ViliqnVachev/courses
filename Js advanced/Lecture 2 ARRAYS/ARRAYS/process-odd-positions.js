function solve(params) {
    return params.filter((e, i) => i % 2 != 0).map(e => e * 2).reverse();
}

console.log(solve([10, 15, 20, 25]));