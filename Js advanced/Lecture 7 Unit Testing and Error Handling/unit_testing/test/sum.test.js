const { assert } = require('chai');
const sum = require('../sum-of-numbers');
describe('Test sum of numbers', () => {
    it('positive', () => {
        let arr = [1, 2, 3, 4, 5];
        let expectedResult = 15;

        assert.equal(expectedResult, sum(arr));
    });

    it('negative', () => {
        let arr = [1, 2, 3, 4, 5];
        let expectedResult = 16;

        assert.notEqual(expectedResult, sum(arr));
    });

    it('negative2', () => {
        let arr = [1, '2, 3, 4, 5'];
        let expectedResult = 16;

        assert.notEqual(expectedResult, sum(arr));
    });

    it('negative', () => {
        let arr = [];
        let expectedResult = 0;

        assert.equal(expectedResult, sum(arr));
    });
})
