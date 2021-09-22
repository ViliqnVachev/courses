function validity(x1, y1, x2, y2) {
    // first check (x1,y1) to (0,0)
    let distance = Math.sqrt(Math.pow((0 - x1), 2) + Math.pow((0 - y1), 2));
    check(x1, y1, 0, 0, distance);

    // second check (x2,y2) to (0,0)
    distance = Math.sqrt(Math.pow((0 - x2), 2) + Math.pow((0 - y2), 2));
    check(x2, y2, 0, 0, distance);

    //third check (x1,y1) to (x2,y2)
    distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    check(x1, y1, x2, y2, distance);


    function print(x1, y1, x2, y2, status) {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is ${status}`);
    }
    function check(x1, y1, x2, y2, result) {
        if (Number.isInteger(result)) {
            print(x1, y1, x2, y2, 'valid')
        } else {
            print(x1, y1, x2, y2, 'invalid')
        }
    }
}

validity(2, 1, 1, 1)