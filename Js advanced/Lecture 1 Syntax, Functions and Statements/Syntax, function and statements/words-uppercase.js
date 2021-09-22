function upper(params) {
    let regex = /[!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~]/g;
    let result = params.toString().toUpperCase().replace(regex, ' ');
    result = result.trim().split(/\s+/);

    console.log(result.join(', '));
}
upper('Hi, how are you?')
upper('Functions in JS can be nested, i.e. hold other functions')