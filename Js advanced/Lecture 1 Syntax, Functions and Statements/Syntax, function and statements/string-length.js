function length(first, second, third) {
    let sum = first.length + second.length + third.length;
    let avr=Math.floor(sum/3);
    console.log(sum);
    console.log(avr);
}

length('chocolate', 'ice cream', 'cake');