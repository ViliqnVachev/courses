function gcd(first, second) {
    first = Number(first);
    second = Number(second);
    let max = Math.max(first, second);
    let min = Math.min(first, second);

    for (let i = max; i >= 0; i--) {
        if (max % i == 0 && min % i == 0) {
            console.log(i);
            return;
        }

    }
}

gcd(15, 5)