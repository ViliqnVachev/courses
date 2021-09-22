class ChristmasDinner {

    constructor(budget) {

        if (budget < 0) {
            throw new Error('The budget cannot be a negative number');
        }
        this.budget = budget;
        this._dishes = [];
        this._products = [];
        this._guests = {};
    }

    shopping(product) {
        let [type, price] = product;
        if (this.budget < price) {
            throw new Error('Not enough money to buy this product');
        }
        this.budget -= price;
        this._products.push(type);
        return `You have successfully bought ${type}!`
    }

    recipes(recipe) {
        let name = recipe.recipeName;
        let neededProd = recipe.productsList;
        let containsProd = true;
        for (const prod of neededProd) {
            containsProd = this._products.includes(prod);
            if (containsProd == false) {
                throw new Error('We do not have this product');
            }
        }
        this._dishes.push({ 'recipeName': name, 'productsList': neededProd });

        return `${name} has been successfully cooked!`;

    }

    inviteGuests(name, dish) {
        //•	If the dish is not present in the dishes array, throw a new error
        //"We do not have this dish"
        let containsDish = false;
        let currentDish = {};
        for (const rec of this._dishes) {
            if (rec.recipeName == dish) {
                containsDish = true;
                currentDish = rec;
            }
        }

        if (containsDish == false) {
            throw new Error('We do not have this dish');
        }
        if (this._guests.hasOwnProperty(name)) {
            throw new Error('This guest has already been invited');
        }

        this._guests[name] = currentDish;

        return `You have successfully invited ${name}!`

    }

    showAttendance() {
        //"{name} will eat {dish}, which consists of {products}
        let result = '';
        for (const key in this._guests) {
            result += `${key} will eat ${this._guests[key].recipeName}, which consists of ${this._guests[key].productsList.join(', ')}\n`;
        }

        return result.trim();

    }
}
let dinner = new ChristmasDinner(300);

console.log(dinner.shopping(['Salt', 1]));
console.log(dinner.shopping(['Beans', 3]));
console.log(dinner.shopping(['Cabbage', 4]));
console.log(dinner.shopping(['Rice', 2]));
console.log(dinner.shopping(['Savory', 1]));
console.log(dinner.shopping(['Peppers', 1]));
console.log(dinner.shopping(['Fruits', 40]));
console.log(dinner.shopping(['Honey', 400]));
console.log(dinner.budget);




dinner.recipes({
    recipeName: 'Oshav',
    productsList: ['Fruits', 'Honey']
});
dinner.recipes({
    recipeName: 'Folded cabbage leaves filled with rice',
    productsList: ['Cabbage', 'Rice', 'Salt', 'Savory']
});
dinner.recipes({
    recipeName: 'Peppers filled with beans',
    productsList: ['Beans', 'Peppers', 'Salt']
});

dinner.inviteGuests('Ivan', 'Oshav');
dinner.inviteGuests('Petar', 'Folded cabbage leaves filled with rice');
dinner.inviteGuests('Georgi', 'Peppers filled with beans');

console.log(dinner.showAttendance());
