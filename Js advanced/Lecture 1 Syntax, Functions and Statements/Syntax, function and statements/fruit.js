function fruit(fruit, weight, money) {
    let weightKg = weight / 1000;
    money *= weightKg;
    console.log(`I need $${money.toFixed(2)} to buy ${weightKg.toFixed(2)} kilograms ${fruit}.`);
}

fruit('orange', 2500, 1.80)