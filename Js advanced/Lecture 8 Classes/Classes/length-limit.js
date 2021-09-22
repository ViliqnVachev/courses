class Stringer {
    constructor(innerString, innerLength) {
        this.innerString = innerString;
        this.innerLength = innerLength;
        this.tempString = innerString;
    }
    decrease(length) {
        if (this.innerLength - length < 0) {
            this.length = 0;
        } else {
            this.innerLength -= length;
        }
    }
    increase(length) {
        if (this.innerLength + length < 0) {
            this.innerLength = 0;
        } else {
            this.innerLength += length;
        }
    }

    toString() {
        if (this.innerString.length > this.innerLength) {
            let temp = this.innerString.split('').reverse()//().substring(0, this.innerString);
            temp.splice(0, this.innerLength);
            this.innerString = temp.reverse().join('');
            return this.innerString + '...';
        }
        return this.innerString;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); // Test

test.decrease(3);
console.log(test.toString()); // Te...

test.decrease(5);
console.log(test.toString()); // ...

test.increase(4);
console.log(test.toString()); // Test
