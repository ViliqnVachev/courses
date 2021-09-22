function solve(params) {
    let result = [];
    params.reduce((acc, x) => {
        if (x === 'remove') {
            result.pop();
            return acc += 1
        }
        result.push(acc += 1)
        return acc;
    }, 0)

    if (result.length == 0) {
        console.log('Empty');
    } else {
        result.forEach(x => console.log(x));
    }
}

solve(
    ['add',
        'add',
        'remove',
        'add',
        'add']


);