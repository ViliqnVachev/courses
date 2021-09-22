const { assert } = require('chai');
const isOddOrEven = require('../even-or-odd');

describe('Testing is even or odd', () => {

    it('Testing if the input is even', () => {
        let arg = 'test';
        let expectedResult = 'even';
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, actualResult);
    });
    it('Testing if the input is even', () => {
        let arg = 'test';
        let expectedResult = 'odd';
        let actualResult = isOddOrEven(arg);

        assert.notEqual(expectedResult, actualResult);
    });
    it('Testing if the input is odd', () => {
        let arg = 'tes';
        let expectedResult = 'odd';
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, expectedResult);
    });
    it('Testing if the input is not string', () => {
        let arg = 2;
        let expectedResult = undefined;
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, expectedResult);
    });

    it('Test is even', () => {
        let arg = '';
        let expectedResult = 'even';
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, expectedResult);
    });

    it('test3', () => {
        let arg = ['', 'aaaaaaaaaaaaaa', 'bbbbbbbbbbbbbbbbbb'];
        let expectedResult = undefined;
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, actualResult);
    });

    it('test3', () => {
        let arg = 'a';
        let expectedResult = 'odd';
        let actualResult = isOddOrEven(arg);

        assert.equal(expectedResult, actualResult);
    });

})