function solve(params) {
    let result = {};
    params.forEach(element => {
        let [town, population] = element.split(' <-> ');
        population = Number(population);

        if (result.hasOwnProperty(town)) {
            population += result[town];
        }
        result[town] = population;

    });

    for (const key in result) {
        console.log(`${key} : ${result[key]}`);
    }
}

console.log(solve(['Istanbul <-> 100000',

    'Istanbul <-> 1000']

));