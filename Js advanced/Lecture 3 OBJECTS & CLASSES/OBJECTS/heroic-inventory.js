function solve(data) {
    let result = [];
    for (const hero of data) {
        let [name, level, items] = hero.split(' / ');
        level = Number(level);
        let obj = {
            name,
            level,
            items: items = items ? items.split(', ') : []
        }
        result.push(obj);
    }
    return JSON.stringify(result);
}
console.log(
    solve(['Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara']
    )
);