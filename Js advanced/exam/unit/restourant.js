class Restaurant {

    constructor(budgetMoney) {
        this.budgetMoney = Number(budgetMoney);
        this.menu = {};
        this.stockProducts = {};
        this.history = [];
    }

    loadProducts(products) {
        for (let product of products) {
            product = product.split(' ');
            let prodName = product[0];
            let quantity = Number(product[1]);
            let price = Number(product[2]);

            if (this.budgetMoney >= price) {
                this.budgetMoney -= price;
                if (!this.stockProducts.hasOwnProperty(prodName)) {
                    this.stockProducts[prodName] = 0;
                }
                this.stockProducts[prodName] += quantity;
                this.history.push(`Successfully loaded ${quantity} ${prodName}`);
            } else {
                this.history.push(`There was not enough money to load ${quantity} ${prodName}`)
            }
        }

        return this.history.join('\n');

    }

    addToMenu(meal, neededProducts, price) {

        if (!this.menu.hasOwnProperty(meal)) {
            let mealObj = {
                meal,
                price,
                neededProducts
            }
            this.menu[meal] = mealObj;

            let menuCount = Object.keys(this.menu).length;
            if (menuCount == 1) {
                return `Great idea! Now with the ${meal} we have 1 meal in the menu, other ideas?`;
            } else {
                return `Great idea! Now with the ${meal} we have ${menuCount} meals in the menu, other ideas?`;
            }

        } else {
            return `The ${meal} is already in the our menu, try something different.`;
        }

    }

    showTheMenu() {
        let countMenu = Object.keys(this.menu).length;
        if (countMenu == 0) {
            return `Our menu is not ready yet, please come later...`;
        }
        let result = '';
        for (const meal in this.menu) {
            result += `${meal} - $ ${this.menu[meal].price}\n`;
        }
        return result.trim();
    }

    makeTheOrder(meal) {
        if (!this.menu.hasOwnProperty(meal)) {
            return `There is not ${meal} yet in our menu, do you want to order something else?`;
        }
        //check needed products
        let products = this.menu[meal].neededProducts;
        for (let product of products) {
            product = product.split(' ');
            let prodName = product[0];
            let quantity = Number(product[1]);
            if (!this.stockProducts.hasOwnProperty(prodName)) {
                return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
            } else {
                if (this.stockProducts[prodName] < quantity) {
                    return `For the time being, we cannot complete your order (${meal}), we are very sorry...`;
                } else {
                    this.stockProducts[prodName] -= quantity;
                }
            }
        }
        this.budgetMoney += this.menu[meal].price;
        return `Your order (${meal}) will be completed in the next 30 minutes and will cost you ${this.menu[meal].price}.`;

    }

}

let kitchen = new Restaurant(1000);
kitchen.loadProducts(['Yogurt 30 3', 'Honey 50 4', 'Strawberries 20 10', 'Banana 5 1']);
kitchen.addToMenu('frozenYogurt', ['Yogurt 30', 'Honey 50', 'Banana 5', 'Strawberries 10'], 9.99);
console.log(kitchen.makeTheOrder('frozenYogurt'));
console.log(kitchen.makeTheOrder('frozenYogurt'));