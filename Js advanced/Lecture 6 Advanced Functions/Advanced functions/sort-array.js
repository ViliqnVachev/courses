function sort(params, criteria) {
    return params.sort((a, b) => {
        if (criteria == 'asc') {
            return a - b;
        }
        return b - a;
    });
}

console.log(sort([14, 7, 17, 6, 8], 'asc'));