function solution(number) {
    return function add(params) {
        return number + params;
    }
}

let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));
