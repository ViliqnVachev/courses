function calc() {
    let a = document.querySelector('#num1');
    let b = document.querySelector('#num2');
    let result = document.querySelector('#sum');
    let sum = Number(a.value) + Number(b.value);
    result.value = sum;
    // TODO: sum = num1 + num2
}
