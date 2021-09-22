const { assert } = require('chai');
const rgb = require('../rgb-to-hex');

describe('Test for rgb func', () => {

    it('Positive', () => {
        let r = 0;
        let g = 0;
        let b = 0;

        let expectedResult = "#" +
            ("0" + r.toString(16).toUpperCase()).slice(-2) +
            ("0" + g.toString(16).toUpperCase()).slice(-2) +
            ("0" + b.toString(16).toUpperCase()).slice(-2);

        assert.equal(expectedResult, rgb(r, g, b));
    });

    it('Positive', () => {
        let r = 255;
        let g = 255;
        let b = 255;

        let expectedResult = "#" +
            ("0" + r.toString(16).toUpperCase()).slice(-2) +
            ("0" + g.toString(16).toUpperCase()).slice(-2) +
            ("0" + b.toString(16).toUpperCase()).slice(-2);

        assert.equal(expectedResult, rgb(r, g, b));
    });

    it('Negative', () => {
        let r = 256;
        let g = 255;
        let b = 255;

        let expectedResult = "#" +
            ("0" + r.toString(16).toUpperCase()).slice(-2) +
            ("0" + g.toString(16).toUpperCase()).slice(-2) +
            ("0" + b.toString(16).toUpperCase()).slice(-2);

        assert.notEqual(expectedResult, rgb(r, g, b));
    });

    it('Negative', () => {
        let r = -256;
        let g = 255;
        let b = 255;

        let expectedResult = "#" +
            ("0" + r.toString(16).toUpperCase()).slice(-2) +
            ("0" + g.toString(16).toUpperCase()).slice(-2) +
            ("0" + b.toString(16).toUpperCase()).slice(-2);

        assert.notEqual(expectedResult, rgb(r, g, b));
    });

    it('Negative', () => {
        let r = -256;
        let g = 255;
        let b = 255;

        let expectedResult = undefined;

        assert.equal(expectedResult, rgb(r, g, b));
    });

    it('Negative', () => {
        let r = '-256';
        let g = 255;
        let b = 255;

        let expectedResult = undefined;

        assert.equal(expectedResult, rgb(r, g, b));
    });

    it('Negative', () => {
        let r = 255;
        let g = 255;
        let b = 255;

        let expectedResult = 'string';

        assert.equal(expectedResult, typeof rgb(r, g, b));
    });
})