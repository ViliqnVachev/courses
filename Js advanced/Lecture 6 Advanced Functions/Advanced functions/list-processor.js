function solve(params) {
    let operations = operationsObj();

    for (const input of params) {
        let [operation, value] = input.split(' ');
        operations[operation](value);
    }

    function operationsObj() {
        let result = [];
        return {

            add(word) {
                result.push(word)
            },
            remove(word) {
                result = result.filter(e => e != word);
            },
            print() {
                console.log(result.join(','));
            }
        }
    }

}
solve(['add hello', 'add again', 'remove hello', 'add again', 'print'])