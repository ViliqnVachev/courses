function solve(params, step) {
    return params.filter((e, i) => i % step == 0);
}

console.log(solve(
    ['1',
        '2',
        '3',
        '4',
        '5'],
    6

));