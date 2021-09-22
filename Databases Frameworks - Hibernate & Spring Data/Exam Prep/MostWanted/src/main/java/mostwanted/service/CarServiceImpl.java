package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.CarImportDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CarServiceImpl implements CarService {
    private final static String CARS_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/cars.json";

    private final CarRepository carRepository;
    private final FileUtil fileUtil;
    private final ValidationUtil validationUtil;
    private final RacerRepository receRacerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, FileUtil fileUtil, ValidationUtil validationUtil, RacerRepository receRacerRepository, Gson gson, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.fileUtil = fileUtil;
        this.validationUtil = validationUtil;
        this.receRacerRepository = receRacerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean carsAreImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsJsonFile() throws IOException {
        return this.fileUtil.readFile(CARS_JSON_FILE_PATH);
    }

    @Override
    public String importCars(String carsFileContent) {
        StringBuilder sb = new StringBuilder();
        CarImportDto[] carImportDtos = gson.fromJson(carsFileContent, CarImportDto[].class);

        for (CarImportDto carImportDto : carImportDtos) {
            Racer racer = this.receRacerRepository.findByName(carImportDto.getRacerName()).orElse(null);

            if (!this.validationUtil.isValid(carImportDto) || racer == null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Car car = this.modelMapper.map(carImportDto, Car.class);
            car.setRacer(racer);
            this.carRepository.saveAndFlush(car);

            String temp = String.format("%s %s @ %d", car.getBrand(), car.getModel(), car.getYearOfProduction());
            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, car.getClass().getSimpleName(), temp)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
