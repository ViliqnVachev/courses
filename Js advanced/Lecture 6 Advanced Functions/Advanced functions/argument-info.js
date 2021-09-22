function solve(...params) {
    let obj = {};

    for (const entry of params) {
        let type = typeof entry;
        if (!obj.hasOwnProperty(type)) {
            obj[type] = 0;
        }
        obj[type]++;
        console.log(`${type}: ${entry}`);
    }

    let entries = Object.entries(obj).sort((a, b) => b[1] - a[1]).forEach(e => console.log(`${e[0]} = ${e[1]}`));
}

solve({ name: 'bob' }, 3.333, 9.999)