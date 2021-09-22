function getInfo() {
    let url = 'http://localhost:3030/jsonstore/bus/businfo/';
    let busID = document.querySelector('#stopId').value;
    let ul = document.querySelector(`#buses`);
    ul.innerHTML = '';

    fetch(`${url}${busID}`)
        .then((response) => response.json())
        .then((data) => {
            editStopName(data.name);
            createli(ul, data)
        })
        .catch((error) => editStopName('Error'))

    function createli(ul, data) {
        for (const key in data.buses) {
            let li = document.createElement('li');
            li.textContent = `Bus ${key} arrives in ${data.buses[key]}`;
            ul.appendChild(li);
        }
    }
    function editStopName(message) {
        document.querySelector('#stopName').textContent = message;
    }
    document.querySelector('#stopId').value = '';
}