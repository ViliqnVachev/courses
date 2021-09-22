function solve(params) {
    let result = {};
    for (let index = 0; index < params.length; index += 2) {
        result[params[index]] = Number(params[index + 1]);
    }
    return result;
}

console.log(solve(
    ['Yoghurt', '48', 'Rise', '138', 'Apple', '52']
));