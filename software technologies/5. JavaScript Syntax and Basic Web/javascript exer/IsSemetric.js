function simtericNumber(arr) {
    let n = Number(arr[0]);
    let result = '';
    for (let i = 1; i <= n; i++) {
        if (isSymetric(i.toString()))
            result += i + " ";
    }
    console.log(result);

    function isSymetric(str) {
        for (let i = 0; i < str.length / 2; i++)
            if (str[i] != str[str.length - i - 1])
                return false;
            return true;


    }

}

simtericNumber('100)