function aggregate(elements) {

    calc(elements, 0, (a, b) => a + b);
    calc(elements, 0, (a, b) => a + 1 / b);
    calc(elements, '', (a, b) => a + b);

    function calc(params, initVal, func) {
        let result = initVal;

        for (let i = 0; i < params.length; i++) {
            result = func(result, params[i]);
        }
        console.log(result);
    }

}

aggregate([1, 2, 3])