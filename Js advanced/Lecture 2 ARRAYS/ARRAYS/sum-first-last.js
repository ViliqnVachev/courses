function solve(params) {
    return Number(params.pop()) + Number(params.shift());
}

console.log(solve(['20', '30', '40']));