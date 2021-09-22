class Hex {
    constructor(value) {
        this.value = value;
    }
    valueOf() {
        return this.value;
    }
    toString() {
        return '0x' + this.value.toString(16).toUpperCase();
    }
    plus(hex) {
        let tmpVal = this.value + hex.valueOf();
        return new Hex(tmpVal);
    }
    minus(hex) {
        let tmpVal = this.value - hex.valueOf();
        return new Hex(tmpVal);
    }
    parse(value) {
        return parseInt(value, 16)
    }
}


