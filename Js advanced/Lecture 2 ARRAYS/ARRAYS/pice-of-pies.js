function solve(pies, first, second) {
    let start = pies.indexOf(first);
    let end = pies.indexOf(second);
    return pies.slice(start, end + 1);
}
console.log(solve(['Pumpkin Pie',
    'Key Lime Pie',
    'Cherry Pie',
    'Lemon Meringue Pie',
    'Sugar Cream Pie'],
    'Key Lime Pie',
    'Lemon Meringue Pie'
));
