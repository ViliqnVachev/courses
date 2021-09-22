function createAssemblyLine() {
    let assemblyLine = {
        hasClima(car) {
            car.temp = 21;
            car.tempSettings = 21;
            car.adjustTemp = () => { car.temp < car.tempSettings ? car.temp++ : car.temp-- }
        },
        hasAudio(car) {
            car.currentTrack = {
                name: null,
                artist: null
            };
            car.nowPlaying = () => { console.log(`Now playing '${car.currentTrack.name}' by ${car.currentTrack.artist}`); }
        },
        hasParktronic(car) {
            car.checkDistance = (distance) => {
                if (distance < 0.1) {
                    console.log('Beep! Beep! Beep!');
                } else if (distance < 0.25) {
                    console.log('Beep! Beep!');
                } else if (distance < 0.5) {
                    console.log('Beep!');
                } else {
                    console.log('');
                }
            }
        }
    }
    return assemblyLine;
}

const assemblyLine = createAssemblyLine();

const myCar = {
    make: 'Toyota',
    model: 'Avensis'
};
assemblyLine.hasAudio(myCar);
myCar.currentTrack = {
    name: 'Never Gonna Give You Up',
    artist: 'Rick Astley'
};
myCar.nowPlaying();

