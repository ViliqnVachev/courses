function generateReport() {
    //get all inputs
    //get all data
    let inputsElements = Array.from(document.querySelectorAll('input'));
    let allTabledataElements = Array.from(document.querySelectorAll('tbody tr'));

    let result = [];

    for (let index = 0; index < allTabledataElements.length; index++) {
        let obj = {};
        let tds = Array.from(allTabledataElements[index].children);
        for (let tdIndex = 0; tdIndex < tds.length; tdIndex++) {
            let tdValue = tds[tdIndex].textContent;
            if (inputsElements[tdIndex].checked === true) {
                let inputName = inputsElements[tdIndex].name;
                obj[inputName] = tdValue
            }
        }
        result.push(obj);
    }
    //output
    document.querySelector('#output').textContent = JSON.stringify(result);
}