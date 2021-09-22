function attachGradientEvents() {
    //get element and attached event
    let gradientElement = document.querySelector('#gradient');
    gradientElement.addEventListener('mousemove', gradientMove);
    gradientElement.addEventListener('mouseout', gradientOut);

    //output

    function gradientMove(event) {
        let power = event.offsetX / (event.target.clientWidth - 1);
        power = Math.trunc(power * 100);
        document.getElementById('result').textContent = power + "%";
    }

    function gradientOut() {
        document.getElementById('result').textContent = '';
    }
}