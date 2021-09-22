function solve(params) {
    let map = new Map();
    let mapBottels = new Map();
    for (const data of params) {
        let [fruit, quantity] = data.split(' => ');
        quantity = Number(quantity);
        if (!map.has(fruit)) {
            map.set(fruit, 0);
        }
        let tempQ = map.get(fruit) + quantity;
        if (tempQ >= 1000) {
            mapBottels.set(fruit, tempQ);
        }
        map.set(fruit, tempQ);
    }

    let etries = Array.from(mapBottels.entries());

    for (const ent of etries) {
        let temp = Math.floor(ent[1] / 1000);
        if (temp > 0) {
            console.log(`${ent[0]} => ${temp}`);
        }
    }
}

console.log(solve(['Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']

));