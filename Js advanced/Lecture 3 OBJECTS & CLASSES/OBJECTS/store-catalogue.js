function solve(params) {
    //sort the input
    params.sort();
    //create obj 
    let result = {};
    //iter over the input
    for (const prod of params) {
        let firstLetter = prod.substring(0, 1);
        if (!result.hasOwnProperty(firstLetter)) {
            result[firstLetter] = [];
        }
        //fill the obj porps
        let [productName, price] = prod.split(' : ')
        result[firstLetter].push({ productName, price });
    }

    //print the obj
    for (const key in result) {
        console.log(key);
        result[key].forEach(element => console.log(`  ${element.productName}: ${element.price}`));
    }

}

console.log(solve(
    ['Appricot : 20.4',
        'Fridge : 1500',
        'TV : 1499',
        'Deodorant : 10',
        'Boiler : 300',
        'Apple : 1.25',
        'Anti-Bug Spray : 15',
        'T-Shirt : 10']

));