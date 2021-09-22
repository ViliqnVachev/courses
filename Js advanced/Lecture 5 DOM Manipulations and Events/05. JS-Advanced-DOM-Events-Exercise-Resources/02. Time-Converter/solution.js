function attachEventsListeners() {
    //get input data
    let inputValueDays = 0;
    let inputValuHours = 0;
    let inputValueMin = 0;
    let inputValueSeconds = 0;

    //create events
    document.querySelector('#daysBtn').addEventListener('click', clickEventHandlerDays);
    document.querySelector('#hoursBtn').addEventListener('click', clickEventHandlerHours);
    document.querySelector('#minutesBtn').addEventListener('click', clickEventHandlerMinutes);
    document.querySelector('#secondsBtn').addEventListener('click', clickEventHandlerSeconds);

    function clickEventHandlerDays(event) {
        console.log(event.target);
        let inputData = Number(event.target.parentElement.querySelector('input').value);
        inputValuHours = inputData * 24;
        inputValueMin = inputValuHours * 60;
        inputValueSeconds = inputValueMin * 60;

        document.querySelector('#hours').value = inputValuHours;
        document.querySelector('#minutes').value = inputValueMin;
        document.querySelector('#seconds').value = inputValueSeconds;
    }

    function clickEventHandlerHours(event) {
        console.log(event.target);
        let inputData = Number(event.target.parentElement.querySelector('input').value);
        inputValueDays = inputData / 24;
        inputValueMin = inputData * 60;
        inputValueSeconds = inputValueMin * 60;

        document.querySelector('#days').value = inputValueDays;
        document.querySelector('#minutes').value = inputValueMin;
        document.querySelector('#seconds').value = inputValueSeconds;
    }

    function clickEventHandlerMinutes(event) {
        console.log(event.target);
        let inputData = Number(event.target.parentElement.querySelector('input').value);
        inputValueDays = inputData / 1440;
        inputValuHours = inputData / 60;
        inputValueSeconds = inputData * 60;

        document.querySelector('#days').value = inputValueDays;
        document.querySelector('#hours').value = inputValuHours;
        document.querySelector('#seconds').value = inputValueSeconds;
    }

    function clickEventHandlerSeconds(event) {
        console.log(event.target);
        let inputData = Number(event.target.parentElement.querySelector('input').value);
        inputValueDays = inputData / 86400;
        inputValuHours = inputData / 3600;
        inputValueMin = inputData / 60;

        document.querySelector('#days').value = inputValueDays;
        document.querySelector('#minutes').value = inputValueMin;
        document.querySelector('#hours').value = inputValuHours;
    }

    console.log('TODO:...');
}