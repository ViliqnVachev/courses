const { assert } = require('chai');
const symmetric = require('../symmetric');

describe('Test symmetric func', () => {
    it('Positive', () => {
        let arr = [1, 1, 2, 1, 1];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });

    it('Negative', () => {
        let arr = [1, 1, 2, 1];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.notEqual(expectedResult, currentResult);

    });

    it('Negative', () => {
        let arr = [1, 1, 2, 1];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.notEqual(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = [];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = [0];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = '[0]';
        let expectedResult = false;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = '[0]';
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.notEqual(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = ['0', '1'];
        let expectedResult = false;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });
    it('Positive', () => {
        let arr = ['1', '0', '1'];
        let expectedResult = true;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });

    it('Positive', () => {
        let arr = ['1', 1];
        let expectedResult = false;
        let currentResult = symmetric(arr);

        assert.equal(expectedResult, currentResult);

    });



})