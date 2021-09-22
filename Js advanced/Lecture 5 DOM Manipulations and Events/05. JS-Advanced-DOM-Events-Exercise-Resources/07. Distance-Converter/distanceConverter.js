function attachEventsListeners() {
    // attach event
    document.querySelector('#convert').addEventListener('click', convert);

    function convert(event) {
        //get input
        let inputValue = Number(event.target.parentElement.querySelector('#inputDistance').value);
        let inputUnitsIndex = event.target.parentElement.querySelector('#inputUnits').selectedIndex;

        let meters = convertToMeters(inputUnitsIndex, inputValue);

        let outputUnitsIndex = document.querySelector('#outputUnits').selectedIndex;
        let outputUnit = convertToUnits(outputUnitsIndex, meters);
        document.querySelector('#outputDistance').value = outputUnit;
    }

    function convertToUnits(unitsIndex, meters) {
        switch (unitsIndex) {
            //km
            case 0: return meters / 1000;
            //m
            case 1: return meters;
            //cm
            case 2: return meters * 100;
            //mm
            case 3: return meters * 1000;
            //mi
            case 4: return meters / 1609.34;
            //yrd
            case 5: return meters * 1.0936;
            //ft
            case 6: return meters * 3.2808;
            //in
            case 7: return meters * 39.370;
        }
    }

    function convertToMeters(unitsIndex, inputValue) {
        switch (unitsIndex) {
            //km
            case 0: return inputValue * 1000;
            //m
            case 1: return inputValue;
            //cm
            case 2: return inputValue / 100;
            //mm
            case 3: return inputValue / 1000;
            //mi
            case 4: return inputValue * 1609.34;
            //yrd
            case 5: return inputValue / 1.0936;
            //ft
            case 6: return inputValue / 3.2808;
            //in
            case 7: return inputValue / 39.370;
        }

    }
    //get input
    //convert intput into meters
    //get output and convert 

}