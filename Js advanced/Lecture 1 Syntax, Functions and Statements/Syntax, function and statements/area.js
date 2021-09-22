function area(input) {
    let type = typeof (input);

    if (type != 'number') {
        console.log(`We can not calculate the circle area, because we receive a ${type}.`);
    } else {
        let area = Math.pow(input, 2) * Math.PI;
        console.log(area.toFixed(2));
    }

}

area(5);