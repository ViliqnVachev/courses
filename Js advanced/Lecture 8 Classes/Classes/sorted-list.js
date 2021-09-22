class List {
    result = [];
    size = 0;
    add(val) {
        this.result.push(val);
        this.size = this.result.length;
        this.result.sort((a, b) => a - b);
    }
    get(index) {
        if (index < 0 || index > this.result.length) {
            return;
        }
        return this.result[index];
    }
    remove(index) {
        if (index < 0 || index > this.result.length) {
            return;
        }

        this.result.splice(index, 1);
        this.result.sort((a, b) => a - b);
        this.size = this.result.length;
    }

}
let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));

