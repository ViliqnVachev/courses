function solve(params) {
    let firstSum = 0;
    let secondSum = 0;
    let result = [];
    for (let index in params) {
        index = Number(index);
        firstSum += params[index][index];
        secondSum += params[index][params[index].length - 1 - index];
    }

    result.push(firstSum);
    result.push(secondSum);
    return result;
}

console.log(solve(
    [[20, 40],
    [10, 60]]
));