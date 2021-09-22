package mostwanted.service;

import mostwanted.common.Constants;
import mostwanted.domain.dtos.race_entry.RaceEntryImportDto;
import mostwanted.domain.dtos.race_entry.RaceEntryImportRootDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class RaceEntryServiceImpl implements RaceEntryService {
    private final static String RACE_ENTRIES_XML_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/race-entries.xml";

    private final RaceEntryRepository raceEntryRepository;
    private final FileUtil fileUtil;
    private final RacerRepository racerRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final CarRepository carRepository;

    @Autowired
    public RaceEntryServiceImpl(RaceEntryRepository raceEntryRepository, FileUtil fileUtil, RacerRepository racerRepository, ModelMapper modelMapper, XmlParser xmlParser, CarRepository carRepository) {
        this.raceEntryRepository = raceEntryRepository;
        this.fileUtil = fileUtil;
        this.racerRepository = racerRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.carRepository = carRepository;
    }

    @Override
    public Boolean raceEntriesAreImported() {
        return raceEntryRepository.count() > 0;
    }

    @Override
    public String readRaceEntriesXmlFile() throws IOException {
        return fileUtil.readFile(RACE_ENTRIES_XML_FILE_PATH);
    }

    @Override
    public String importRaceEntries() throws JAXBException {
        StringBuilder sb = new StringBuilder();
        RaceEntryImportRootDto raceEntryImportRootDto = xmlParser.parseXml(RaceEntryImportRootDto.class, RACE_ENTRIES_XML_FILE_PATH);

        for (RaceEntryImportDto raceEntryImportDto : raceEntryImportRootDto.getRaceEntryImportDto()) {

            Racer racer = this.racerRepository.findByName(raceEntryImportDto.getRacer()).orElse(null);
            Car car = this.carRepository.findById(raceEntryImportDto.getCarId()).orElse(null);

            if (racer == null || car == null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            RaceEntry raceEntry = this.modelMapper.map(raceEntryImportDto, RaceEntry.class);
            raceEntry.setRacer(racer);

            raceEntry.setCar(car);

            raceEntry.setRace(null);
            raceEntry = this.raceEntryRepository.saveAndFlush(raceEntry);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, raceEntry.getClass().getSimpleName(), raceEntry.getId()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
