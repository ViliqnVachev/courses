function solve(params) {
    let biggestNumber = Number.MIN_SAFE_INTEGER;
    let result = params.reduce((acc, x) => {
        if (x >= biggestNumber) {
            biggestNumber = Number(x);
            acc.push(x);
        }
        return acc;
    }, []);
    return result;
}

console.log(solve(
    [1,
        3,
        8,
        4,
        10,
        12,
        3,
        2,
        24]

));