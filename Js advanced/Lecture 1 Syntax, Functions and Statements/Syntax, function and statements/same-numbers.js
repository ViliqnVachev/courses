function sameNumbers(params) {
    let firstDigit = params % 10;
    let numString = params.toString();
    let areEqual = true;
    let result = 0;

    for (let i = 0; i < numString.length; i++) {
        if (numString[i] != firstDigit) {
            areEqual = false;
        }
        result += Number(numString[i]);
    }

    console.log(areEqual);
    console.log(result);
}
sameNumbers(1234)