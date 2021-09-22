function attachEvents() {
    //atach event
    let submitBtn = document.querySelector('#submit');
    submitBtn.addEventListener('click', getDataHandler);
    let symbols = {
        Sunny() { return '☀'; },
        'Partly sunny'() { return '⛅' },
        Overcast() { return '☁' },
        Rain() { return '☂' },

    }


    function getDataHandler(e) {
        let url = 'http://localhost:3030/jsonstore/forecaster';

        fetch(`${url}/locations`)
            .then(response => response.json())
            .then(data => {
                let location = document.querySelector('#location').value;
                let city = data.find(e => e.name == location);
                let currentDIv = document.querySelector('#forecast');

                let today = fetch(`http://localhost:3030/jsonstore/forecaster/today/${city.code}`)
                    .then(response => response.json())
                    .then(data => {
                        let currentDIv = document.querySelector('#current');
                        createCurentHTML(data, currentDIv);
                    })

                let nextDays = fetch(`http://localhost:3030/jsonstore/forecaster/upcoming/${city.code}`)
                    .then(response => response.json())
                    .then(data => {
                        let upcomingtDIv = document.querySelector('#upcoming');
                        createUpcomingHTML(data, upcomingtDIv);
                    })

                Promise.all([today, nextDays]).then(response => currentDIv.style.display = 'block');
            }).catch(error => {
                let divError = document.createElement('div');
                divError.classList.add('forecasts-info');
                divError.textContent = "Error";
                document.querySelector('#upcoming').appendChild(divError);
                let currentDIv = document.querySelector('#forecast').style.display = 'block'
            });
    }

    function createUpcomingHTML(obj, parantDiv) {
        let divElement = document.createElement('div');
        divElement.classList.add('forecasts-info');


        for (const data of obj.forecast) {
            let spanUpcoming = document.createElement('span');
            spanUpcoming.classList.add('upcoming');

            let spanSymbol = document.createElement('span');
            spanSymbol.classList.add('symbol');
            spanSymbol.textContent = symbols[data.condition]();

            let spandDegrees = document.createElement('span');
            spandDegrees.classList.add('forecast-data');
            spandDegrees.textContent = `${data.low}°/${data.high}°`

            let spanConditionName = document.createElement('span')
            spanConditionName.classList.add('forecast-data');
            spanConditionName.textContent = data.condition;

            spanUpcoming.appendChild(spanSymbol);
            spanUpcoming.appendChild(spandDegrees);
            spanUpcoming.appendChild(spanConditionName);
            divElement.appendChild(spanUpcoming);
        }

        parantDiv.appendChild(divElement);
    }

    function createCurentHTML(obj, parantDiv) {
        let divElement = document.createElement('div');
        divElement.classList.add('forecasts');

        let spanSymbol = document.createElement('span');
        spanSymbol.classList.add('condition');
        spanSymbol.classList.add('symbol');
        spanSymbol.textContent = symbols[obj.forecast.condition]();

        let spanCondition = document.createElement('span');
        spanCondition.classList.add('condition');

        let spanName = document.createElement('span');
        spanName.classList.add('forecast-data');
        spanName.textContent = obj.name;

        let spandDegrees = document.createElement('span');
        spandDegrees.classList.add('forecast-data');
        spandDegrees.textContent = `${obj.forecast.low}°/${obj.forecast.high}°`

        let spanConditionName = document.createElement('span')
        spanConditionName.classList.add('forecast-data');
        spanConditionName.textContent = obj.forecast.condition;

        spanCondition.appendChild(spanName);
        spanCondition.appendChild(spandDegrees);
        spanCondition.appendChild(spanConditionName);

        divElement.appendChild(spanSymbol);
        divElement.appendChild(spanCondition);
        parantDiv.appendChild(divElement);
    }

}

attachEvents();