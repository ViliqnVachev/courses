function solve(params) {
    let [town, latitude, longitude] = params.shift().split('|').filter(e => e != '').map(e => e.trim());
    let result = [];
    for (const data of params) {
        let [townName, lat, long] = data.split('|').filter(e => e != '').map(e => e.trim());
        lat = Number(Number(lat).toFixed(2));
        long = Number(Number(long).toFixed(2));
        result.push({
            [town]: townName,
            [latitude]: lat,
            [longitude]: long
        })
    }
    return JSON.stringify(result);
}

console.log(solve(
    ['| Town | Latitude | Longitude |',
        '| Sofia | 42.696552 | 23.32601 |',
        '| Beijing | 39.913818 | 116.363625 |']

));