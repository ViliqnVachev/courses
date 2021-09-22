function cook(number, param2, param3, param4, param5, param6) {
    number = Number(number);
    let operations = [param2, param3, param4, param5, param6];

    for (let i = 0; i < operations.length; i++) {
        number = doOperation(number, operations[i]);
        console.log(number);
    }

    function doOperation(number, operation) {
        switch (operation) {
            case 'chop': return number / 2;
            case 'dice': return Math.sqrt(number);
            case 'spice': return number + 1;
            case 'bake': return number * 3;
            case 'fillet': return number - (number * 0.2);
        }
    }
}

cook('9', 'dice', 'spice', 'chop', 'bake', 'fillet')