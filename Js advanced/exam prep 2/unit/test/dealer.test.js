const { assert } = require("chai");

let dealership = require('../dealer')

describe("dealershi", function () {
    describe("newCarCost", function () {

        it("Should return newPrice when set new car", function () {
            assert.equal(dealership.newCarCost('Lada', 5000), 5000);
            assert.equal(dealership.newCarCost('Fiat', 5000.123), 5000.123);
        });

        it("Should return fixedPrice when set old car", function () {
            assert.equal(dealership.newCarCost('Audi A4 B8', 50000), 35000);
            assert.equal(dealership.newCarCost('Audi A6 4K', 60000), 40000);
            assert.equal(dealership.newCarCost('Audi A8 D5', 50500), 25500);
            assert.equal(dealership.newCarCost('Audi TT 8J', 20000), 6000);
            assert.equal(dealership.newCarCost('Audi TT 8J', 20000, 50), 6000, 50);
        });
    });

    describe("carEquipment", function () {

        it("Should return extras when set indexes", function () {
            let extras = ['heated seats', 'sliding roof', 'sport rims', 'navigation'];

            assert.deepEqual(dealership.carEquipment(extras, [0]), ['heated seats']);
            assert.deepEqual(dealership.carEquipment(extras, []), []);
            assert.deepEqual(dealership.carEquipment(extras, [0, 2]), ['heated seats', 'sport rims']);
            assert.deepEqual(dealership.carEquipment(extras, [0, 1, 2, 3]), ['heated seats', 'sliding roof', 'sport rims', 'navigation']);
            assert.deepEqual(dealership.carEquipment(extras, [2, 3]), ['sport rims', 'navigation']);
        });

    });


    describe("euroCategory", function () {

        it("Should return no discount when set lower category", function () {
            let expected = 'Your euro category is low, so there is no discount from the final price!';
            assert.equal(dealership.euroCategory(0), expected);
            assert.equal(dealership.euroCategory(1), expected);
            assert.equal(dealership.euroCategory(2), expected);
            assert.equal(dealership.euroCategory(3), expected);
        });

        it("Should return discount when set higher category", function () {
            let expected = `We have added 5% discount to the final price: 14250.`;
            assert.equal(dealership.euroCategory(4), expected);
            assert.equal(dealership.euroCategory(5), expected);
        });

    });

});
