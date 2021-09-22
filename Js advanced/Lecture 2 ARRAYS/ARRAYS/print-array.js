function solve(params, delimeter) {
    return params.join(delimeter);
}

console.log(solve(
    ['One',
        'Two',
        'Three',
        'Four',
        'Five'],
    '-'

));