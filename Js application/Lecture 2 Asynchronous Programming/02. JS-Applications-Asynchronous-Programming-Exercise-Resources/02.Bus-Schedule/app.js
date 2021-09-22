function solve() {
    let url = `http://localhost:3030/jsonstore/bus/schedule/`;
    let nextStopId = 'depot';
    let departBtn = document.querySelector('#depart');
    let arriveBtn = document.querySelector('#arrive');

    function depart() {
        fetch(`${url}${nextStopId}`)
            .then((response) => response.json())
            .then((data) => {
                document.querySelector('#info').textContent = `Next stop ${data.name}`;
                nextStopId = data.next;
                departBtn.disabled = 'true';
                arriveBtn.removeAttribute('disabled');
            }).catch((error) => {
                document.querySelector('#info').textContent = `Error`;
                arriveBtn.disabled = 'true';
                departBtn.disabled = 'true';
            })
    }

    function arrive() {
        fetch(`${url}${nextStopId}`)
            .then((response) => response.json())
            .then((data) => {
                document.querySelector('#info').textContent = `Arraving at ${data.name}`;
                nextStopId = data.next;
                departBtn.removeAttribute('disabled');
                arriveBtn.disabled = 'true';
            }).catch((error) => {
                document.querySelector('#info').textContent = `Error`;
                arriveBtn.disabled = 'true';
                departBtn.disabled = 'true';
            })
    }

    return {
        depart,
        arrive
    };
}

let result = solve();