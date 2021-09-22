function solve(params) {

    return params.sort((a, b) => {
        return a.localeCompare(b);
    }).forEach((e, index) => console.log(`${index + 1}.${e}`));

}

console.log(solve(
    ["John", "Bob", "Christina", "Ema"]
));