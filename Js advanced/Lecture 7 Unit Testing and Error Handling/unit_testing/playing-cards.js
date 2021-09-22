function solve(card, sign) {
    let cards = ['J', 'Q', 'K', 'A'];
    let suits = ['S', 'H', 'D', 'C'];
    if (Number(card) == 'NaN' || card < 2 || card > 10) {
        if (!cards.includes(cards)) {
            throw new Error;
        }
    }
    if (!suits.includes(sign)) {
        throw new Error;
    }

    switch (sign) {
        case 'S': return card + '\u2660';
        case 'H': return card + '\u2665';
        case 'D': return card + '\u2666';
        case 'C': return card + '\u2663';
    }

}

console.log(solve('1', 'S'));