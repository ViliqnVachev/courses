function rectangle(width, height, color) {
    firstChar = color.charAt(0);
    colorName = color.replace(firstChar, firstChar.toUpperCase());
    return {
        width: Number(width),
        height: Number(height),
        color: colorName,
        calcArea() { return this.width * this.height }
    }
}

let rect = rectangle(4, 5, 'red');
console.log(rect.width);
console.log(rect.height);
console.log(rect.color);
console.log(rect.calcArea());
