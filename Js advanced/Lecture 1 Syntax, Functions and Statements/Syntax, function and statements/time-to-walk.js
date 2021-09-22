function timeToWalk(steps, foot, speedKm) {

    let speedM = speedKm / 3.6;
    let distanceM = steps * foot;
    let rest = (Math.floor(distanceM / 500)) * 60;
    let finalTimeInSeconds = (distanceM / speedM) + rest;

    let hours = Math.floor(finalTimeInSeconds / 3600);
    let minutes = Math.floor(finalTimeInSeconds / 60);
    let seconds = Math.ceil(finalTimeInSeconds % 60);

    console.log(`${hours < 10 ? 0 : ""}${hours}:${minutes < 10 ? 0 : ""}${minutes}:${seconds < 10 ? 0 : ""}${seconds}`);
}

timeToWalk(4000, 0.60, 5)