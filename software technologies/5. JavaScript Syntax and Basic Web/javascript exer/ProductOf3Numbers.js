function slove(arr) {
    let num1 = Number(arr[0]);
    let num2 = Number(arr[1]);
    let num3 = Number(arr[2]);
    let count = 0;
    if (num1 < 0) {
        count++;
    }
    if(num2<0){
        count++;
    }
    if(num3<0){
        count++;
    }

    if(count%2==0){
        console.log('Positive');
    }else {
        console.log('Negative');
    }

}

slove([2,-3,-1])