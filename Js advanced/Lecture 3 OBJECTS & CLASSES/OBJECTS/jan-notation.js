function solve(params) {
    let nums = [];
    for (const op of params) {
        if (typeof op == 'number') {
            nums.push(op);
            continue;
        } else {
            let b = nums.pop();
            let a = nums.pop();
            if (a == undefined || b == undefined) {
                console.log('Error: not enough operands!');
                return;
            }
            nums.push(makeOperation(a, b, op));
        }

    }

    if (nums.length > 1) {
        console.log('Error: too many operands!');
    } else {
        return Math.ceil(nums[0]);
    }

    function makeOperation(a, b, operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
    }

}

console.log(solve(
    [15,
        '/']

));