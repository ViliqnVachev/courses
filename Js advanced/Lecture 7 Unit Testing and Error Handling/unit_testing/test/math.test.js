const { assert } = require('chai');
const mathEnforcer = require('../math');

describe('Test for math obj addFive', () => {
    describe('Test for math obj addFive', () => {
        it('Should return undefined when add not a number', () => {
            assert.equal(mathEnforcer.addFive('5'), undefined);
            assert.equal(mathEnforcer.addFive(''), undefined);
            assert.equal(mathEnforcer.addFive('5.5'), undefined);
            assert.equal(mathEnforcer.addFive(null), undefined);
            assert.equal(mathEnforcer.addFive(undefined), undefined);
            assert.equal(mathEnforcer.addFive('test'), undefined);
            assert.equal(mathEnforcer.addFive([5]), undefined);
        });

        it('Should return +5  when add a number', () => {
            assert.equal(mathEnforcer.addFive(5), 10);
            assert.closeTo(mathEnforcer.addFive(2.22), 7.22, 0.01);
            assert.closeTo(mathEnforcer.addFive(1.03 + 2.22), 8.25, 0.01);
            assert.equal(mathEnforcer.addFive(0), 5);
            assert.equal(mathEnforcer.addFive(-8), -3);
        });
    })

    describe('Test for math obj subtractTen', () => {
        it('Should return undefined when set not a number', () => {
            assert.equal(mathEnforcer.subtractTen('5'), undefined);
            assert.equal(mathEnforcer.subtractTen(''), undefined);
            assert.equal(mathEnforcer.subtractTen(null), undefined);
            assert.equal(mathEnforcer.subtractTen(undefined), undefined);
            assert.equal(mathEnforcer.subtractTen('5.5'), undefined);
            assert.equal(mathEnforcer.subtractTen('test'), undefined);
            assert.equal(mathEnforcer.subtractTen([5]), undefined);
        });

        it('Should return -5  when add a number', () => {
            assert.equal(mathEnforcer.subtractTen(5), -5);
            assert.closeTo(mathEnforcer.subtractTen(10.22), 0.22, 0.01);
            assert.closeTo(mathEnforcer.subtractTen(1.1 + 1.2), -7.7, 0.01);
            assert.equal(mathEnforcer.subtractTen(0), -10);
            assert.equal(mathEnforcer.subtractTen(20), 10);
            assert.equal(mathEnforcer.subtractTen(10), 0);
            assert.equal(mathEnforcer.subtractTen(-3), -13);
        });
    })

    describe('Test for math obj sum', () => {
        it('Should return undefined when set First param not a number', () => {
            assert.equal(mathEnforcer.sum('5', 2), undefined);
            assert.equal(mathEnforcer.sum('', 3), undefined);
            assert.equal(mathEnforcer.sum('5.5', 4), undefined);
            assert.equal(mathEnforcer.sum('test', 5), undefined);
            assert.equal(mathEnforcer.sum(null, 5), undefined);
            assert.equal(mathEnforcer.sum(undefined, 5), undefined);
            assert.equal(mathEnforcer.sum([5], 5), undefined);
        });

        it('Should return undefined when set Second param not a number', () => {
            assert.equal(mathEnforcer.sum(2, '5'), undefined);
            assert.equal(mathEnforcer.sum(3, ''), undefined);
            assert.equal(mathEnforcer.sum(4, '5.5'), undefined);
            assert.equal(mathEnforcer.sum(5, 'test'), undefined);
            assert.equal(mathEnforcer.sum(5, null), undefined);
            assert.equal(mathEnforcer.sum(5, undefined), undefined);
            assert.equal(mathEnforcer.sum(6, [5]), undefined);
        });

        it('Should return correct resul when add a number', () => {
            assert.equal(mathEnforcer.sum(5, 8), 13);
            assert.equal(mathEnforcer.sum(-10, 22), 12);
            assert.equal(mathEnforcer.sum(10, -22), -12);
            assert.equal(mathEnforcer.sum(-3, -2), -5);
            assert.closeTo(mathEnforcer.sum(20, 0.55), 20.55, 0.01);
            assert.closeTo(mathEnforcer.sum(1.1 + 2.2, 3), 6.3, 0.01);
        });
    })
})