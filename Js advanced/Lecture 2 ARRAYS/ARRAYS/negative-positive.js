function solve(params) {
    let result = [];
    for (const num of params) {
        let number = Number(num);
        if (number < 0) {
            result.unshift(number)
        } else {
            result.push(number)
        }
    }

    result.forEach(e => console.log(e));
}

solve([7, -10, -2, 0, 8, 9])