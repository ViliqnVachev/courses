const { assert, expect } = require('chai');
const lookupChar = require('../char-lookup');

describe('Test char func', () => {
    it('Should fail when fill wrong params', () => {
        assert.equal(undefined, lookupChar(1, 1));
        assert.equal(undefined, lookupChar('Test', 'test'));
        assert.equal(undefined, lookupChar('Test', '1'));
        assert.equal(undefined, lookupChar('Test', 1.55));
    })

    it('Should return error when index is wrong', () => {
        assert.equal('Incorrect index', lookupChar('Test', -5));
        assert.equal('Incorrect index', lookupChar('Test', 100));
        assert.equal('Incorrect index', lookupChar('Test', 4));
        assert.equal('Incorrect index', lookupChar('', 0));
    })

    it('Should pass when all is correct', () => {
        assert.equal('T', lookupChar('Test', 0));
        assert.equal('m', lookupChar('some', 2));
        assert.equal('t', lookupChar('Test', 3));
    })
})