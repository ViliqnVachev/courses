function radar(speed, area) {

    switch (area) {
        case 'motorway':
            checkSpeed(speed, 130);
            break;
        case 'interstate':
            checkSpeed(speed, 90);
            break;
        case 'city':
            checkSpeed(speed, 50);
            break;
        case 'residential':
            checkSpeed(speed, 20);
            break;

        default:
            break;
    }

    function checkSpeed(currentSpeed, limit) {
        let faster = Math.abs(limit - currentSpeed);
        if (currentSpeed <= limit) {
            console.log(`Driving ${currentSpeed} km/h in a ${limit} zone`);
        } else if (faster <= 20) {
            printMessage(faster, limit, 'speeding');
        } else if (faster <= 40) {
            printMessage(faster, limit, 'excessive speeding');
        } else {
            printMessage(faster, limit, 'reckless driving');
        }
    }

    function printMessage(faster, limit, status) {
        console.log(`The speed is ${faster} km/h faster than the allowed speed of ${limit} - ${status}`);
    }

}

radar(21, 'residential')