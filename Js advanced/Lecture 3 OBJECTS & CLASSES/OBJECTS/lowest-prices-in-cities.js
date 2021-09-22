function solve(data) {
    let obj = {};
    let result = [];
    //for (const entry of data) {
    //    let [town, product, price] = entry.split(' | ');
    //    let prodObj = { product, town, price };
    //    result.push(prodObj);
    //}
    for (const entr of data) {
        let [town, product, price] = entr.split(' | ');
        price = Number(price);
        if (obj.hasOwnProperty(product)) {
            let hasTheSameCity = false;
            obj[product].data.forEach(element => {
                if (element.town === town) {
                    hasTheSameCity = true;
                    obj[product][filter] = false;
                }
            });
            if (!hasTheSameCity) {
                obj[product].push({ town, price });
            }
        } else {
            obj[product].data = [{ town, price }];
            obj[product] = { filter: true };
        }
    }
    for (const key in obj) {
        let result = obj[key].sort((a, b) => a.price - b.price);
        console.log(`${key} -> ${result[0].price} (${result[0].town})`);
    }
}

console.log(solve(
    ['Sofia City | Audi | 100000',
        'Mexico City | Audi | 1000',
        'Mexico City | Audi | 100000',
        'Washington City | Mercedes | 1000']

));

['Sofia City | Audi | 100000',
    'Sofia City | BMW | 100000',
    'Sofia City | Mitsubishi | 10000',
    'Sofia City | Mercedes | 10000',
    'Sofia City | NoOffenseToCarLovers | 0',
    'Mexico City | Audi | 1000',
    'Mexico City | BMW | 99999',
    'New York City | Mitsubishi | 10000',
    'New York City | Mitsubishi | 1000',
    'Mexico City | Audi | 100000',
    'Washington City | Mercedes | 1000']