function solve(params, steps) {
    for (let i = 0; i < steps; i++) {
        let element = params.pop();
        params.unshift(element);
    }
    return params.join(' ');
}

console.log(solve(
    ['1',
        '2',
        '3',
        '4'],
    2

));