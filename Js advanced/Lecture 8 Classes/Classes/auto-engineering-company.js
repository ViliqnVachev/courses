function solve(params) {
    let map = new Map();

    for (const ent of params) {
        let [brand, model, quantity] = ent.split(' | ');
        quantity = Number(quantity);
        let car = {
            [model]: quantity
        }
        if (!map.has(brand)) {
            map.set(brand, car);
        } else {
            let tmp = map.get(brand);
            if (!tmp.hasOwnProperty(model)) {
                tmp[model] = quantity;
            } else {
                tmp[model] += quantity;
            }
            map.set(brand, tmp);
        }
    }

    let entries = Array.from(map.entries());
    let result = '';
    for (const ent of entries) {
        result += ent[0] + '\n';
        for (const tmp in ent[1]) {
            result += `###${tmp} -> ${ent[1][tmp]}\n`
        }
    }
    return result.trim();
}

console.log(solve(['Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']
));