const { assert } = require('chai');
const numberOperations = require('../03. Number Operations_Resources');



describe("Tests for number operations", function () {
    describe("powerNumbers", function () {
        it("Should pass when all params are correct", function () {
            assert.equal(numberOperations.powNumber(3), 9);
            assert.equal(numberOperations.powNumber(0), 0);
            assert.equal(numberOperations.powNumber(-2), 4);
            assert.closeTo(numberOperations.powNumber(2.2), 4.84, 0.1);
        });
    });

    describe("numberChecker", function () {
        it("Should failed when parameter is not a number", function () {
            assert.throws(() => numberOperations.numberChecker('test'), Error);
            assert.throws(() => numberOperations.numberChecker('A'), Error);
        });
        it("Should return < when number is < 100", function () {
            let expected = 'The number is lower than 100!';
            assert.equal(numberOperations.numberChecker(-2), expected);
            assert.equal(numberOperations.numberChecker(0), expected);
            assert.equal(numberOperations.numberChecker(99), expected);
            assert.equal(numberOperations.numberChecker(''), expected);
            assert.equal(numberOperations.numberChecker('10'), expected);
            assert.equal(numberOperations.numberChecker(2.55), expected);
            assert.equal(numberOperations.numberChecker('-8'), expected);
            assert.equal(numberOperations.numberChecker(-2.999), expected);
        });

        it("Should return > when number is >= 100", function () {
            let expected = 'The number is greater or equal to 100!';
            assert.equal(numberOperations.numberChecker(100), expected);
            assert.equal(numberOperations.numberChecker('100'), expected);
            assert.equal(numberOperations.numberChecker(900), expected);
            assert.equal(numberOperations.numberChecker(999.55), expected);
            assert.equal(numberOperations.numberChecker('895.5'), expected);
        });
    });

    describe("sumArrays", function () {
        it("Should pass when all params are correct", function () {
            assert.isArray(numberOperations.sumArrays([1, 2], [1]));

            assert.deepEqual(numberOperations.sumArrays([1, 2], [1]), [2, 2]);
        });
    });
});

