function toggle() {
    let spanElement = document.querySelector('.button');
    let divElement = document.querySelector('#extra');
    if (spanElement.textContent == 'More') {
        spanElement.textContent = 'Less';
        divElement.style.display = 'block';

    } else {
        spanElement.textContent = 'More';
        divElement.style.display = 'none';
    }
    console.log('TODO:...');
}