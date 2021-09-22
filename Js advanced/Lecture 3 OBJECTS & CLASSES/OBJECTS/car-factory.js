function solve(car) {

    let volume = 0;
    let engPower = 0;
    if (car.power <= 90) {
        volume = 1800;
        engPower = 90;
    } else if (car.power <= 120) {
        volume = 2400;
        engPower = 120;
    } else {
        volume = 3500;
        engPower = 200;
    }

    let size = car.wheelsize % 2 == 0 ? car.wheelsize - 1 : car.wheelsize;

    let orderedCar = {
        model: car.model,
        engine: { power: engPower, volume: volume },
        carriage: {
            type: car.carriage,
            color: car.color
        },
        wheels: [size, size, size, size]
    };
    return orderedCar;
}

console.log(solve(
    {
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }

));