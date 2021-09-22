function solve(params) {
   return params.sort((a, b) => a - b).slice(0,2);
}
solve([30, 15, 50, 5])