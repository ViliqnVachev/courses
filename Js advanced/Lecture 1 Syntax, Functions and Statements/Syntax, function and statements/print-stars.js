function print(input) {
    let number = Number(input);
    let star = '* ';

    for (let i = 0; i < number; i++) {
        console.log(star.repeat(number));
    }
}

print(5)