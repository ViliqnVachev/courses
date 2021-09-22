const { assert } = require('chai');
const testNumbers = {
    sumNumbers: function (num1, num2) {
        let sum = 0;

        if (typeof (num1) !== 'number' || typeof (num2) !== 'number') {
            return undefined;
        } else {
            sum = (num1 + num2).toFixed(2);
            return sum
        }
    },
    numberChecker: function (input) {
        input = Number(input);

        if (isNaN(input)) {
            throw new Error('The input is not a number!');
        }

        if (input % 2 === 0) {
            return 'The number is even!';
        } else {
            return 'The number is odd!';
        }

    },
    averageSumArray: function (arr) {

        let arraySum = 0;

        for (let i = 0; i < arr.length; i++) {
            arraySum += arr[i]
        }

        return arraySum / arr.length
    }
};


describe("Tests for test numbers func", function () {
    describe("sumNumbers", function () {
        it("Should return undefind when first param is not a numbers", function () {
            assert.equal(testNumbers.sumNumbers('a', 1), undefined);
            assert.equal(testNumbers.sumNumbers('5', 2), undefined);
            assert.equal(testNumbers.sumNumbers('-5', 3), undefined);
            assert.equal(testNumbers.sumNumbers('5.55', 4), undefined);
            assert.equal(testNumbers.sumNumbers('', 5), undefined);
            assert.equal(testNumbers.sumNumbers(undefined, 6), undefined);
            assert.equal(testNumbers.sumNumbers([1], 7), undefined);
        });

        it("Should return undefind when second param is not a numbers", function () {
            assert.equal(testNumbers.sumNumbers(1, 'a'), undefined);
            assert.equal(testNumbers.sumNumbers(2, '5'), undefined);
            assert.equal(testNumbers.sumNumbers(3.3, '-5'), undefined);
            assert.equal(testNumbers.sumNumbers(5, '5.55'), undefined);
            assert.equal(testNumbers.sumNumbers(6, ''), undefined);
            assert.equal(testNumbers.sumNumbers(7, undefined), undefined);
            assert.equal(testNumbers.sumNumbers(9, [1]), undefined);
        });

        it("Should return undefind when both param are not a numbers", function () {
            assert.equal(testNumbers.sumNumbers('1', 'a'), undefined);
            assert.equal(testNumbers.sumNumbers('asd', '5'), undefined);
            assert.equal(testNumbers.sumNumbers('number', '-5'), undefined);
            assert.equal(testNumbers.sumNumbers('[1]', '5.55'), undefined);
            assert.equal(testNumbers.sumNumbers('', ''), undefined);
            assert.equal(testNumbers.sumNumbers(undefined, undefined), undefined);
            assert.equal(testNumbers.sumNumbers([9], [1]), undefined);
        });

        it("Should return result when both param are  numbers", function () {
            assert.equal(testNumbers.sumNumbers(5, 8), 13);
            assert.equal(testNumbers.sumNumbers(-5, 8), 3);
            assert.equal(testNumbers.sumNumbers(-5, -5), -10);
            assert.equal(testNumbers.sumNumbers(-5, 5), 0);
            assert.equal(testNumbers.sumNumbers(0, 2.5555), 2.56);
            assert.equal(testNumbers.sumNumbers(2.5555, 0.1), 2.66);
            assert.equal(testNumbers.sumNumbers(-2.5555, -0.1), -2.66);
            assert.equal(testNumbers.sumNumbers(5 + 5, 8), 18);
            assert.equal(testNumbers.sumNumbers(5 + 5, 8 + 1), 19);
        });
    });

    describe("numberChecker", function () {
        it("Should thown error when param is not a number", function () {
            assert.throws(() => testNumbers.numberChecker('test'), Error);
            assert.throws(() => testNumbers.numberChecker('[]'), Error);
            assert.throws(() => testNumbers.numberChecker(undefined), Error);
            assert.throws(() => testNumbers.numberChecker('number'), Error);
            assert.throws(() => testNumbers.numberChecker('[1]'), Error);
        });

        it("Should return even when number is even", function () {
            let expected = 'The number is even!';
            assert.equal(testNumbers.numberChecker(4), expected);
            assert.equal(testNumbers.numberChecker(-4), expected);
            assert.equal(testNumbers.numberChecker(0), expected);
        });

        it("Should return odd when number is odd", function () {
            let expected = 'The number is odd!';
            assert.equal(testNumbers.numberChecker(1), expected);
            assert.equal(testNumbers.numberChecker(-11), expected);
            assert.equal(testNumbers.numberChecker(13), expected);
        });

    });

    describe("averageSumArray", function () {
        it("Should return avrg sum", function () {
            assert.equal(testNumbers.averageSumArray([2, 4, 6]), 4);
            assert.equal(testNumbers.averageSumArray([5]), 5);
            assert.equal(testNumbers.averageSumArray([0]), 0);
            assert.equal(testNumbers.averageSumArray([-2, -4, -6]), -4);
            assert.equal(testNumbers.averageSumArray([-2, 5, 6]), 3);
        });
    });

});
