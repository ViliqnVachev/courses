function createSortedList() {
    let result = [];
    return {
        result,
        size: 0,
        add(element) {
            this.result.push(element);
            this.result.sort((a, b) => a - b);
            this.size = this.result.length
        },
        remove(index) {
            index < 0 || index > this.result.length ? '' : this.result.splice(index, 1);
            this.result.sort((a, b) => a - b);
            this.size = this.result.length
        },
        get(index) {
            if (index < 0 || index > this.result.length) {
                return
            }
            return this.result[index]
        }
    }
}
let list = createSortedList();
list.add(7);
list.add(6);
list.add(5);

console.log(list.size);

