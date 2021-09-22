function solve(params) {
    return params.sort((a, b) => {
        if (a.length > b.length) {
            return 1;
        } else if (a.length < b.length) {
            return -1;
        } else {
            return a.localeCompare(b);
        }
    }).forEach(element => console.log(element));
}

console.log(solve(
    ['test',
        'Deny',
        'omen',
        'Default']

));