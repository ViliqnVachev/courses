function sum(first, second) {
    first = Number(first);
    second = Number(second);
    let sum = 0;
    for (let i = first; i <= second; i++) {
        sum += i;
    }

    console.log(sum);
}

sum('1', '5')