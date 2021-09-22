package mostwanted.service;

import mostwanted.common.Constants;
import mostwanted.domain.dtos.races.EntryImportDto;
import mostwanted.domain.dtos.races.RaceImportDto;
import mostwanted.domain.dtos.races.RaceImportRootDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Race;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RaceRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import mostwanted.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService {
    private final static String RACES_XML_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/races.xml";

    private final RaceRepository raceRepository;
    private final FileUtil fileUtil;
    private final RaceEntryRepository raceEntryRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final DistrictRepository districtRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public RaceServiceImpl(RaceRepository raceRepository, FileUtil fileUtil, RaceEntryRepository raceEntryRepository, XmlParser xmlParser, ModelMapper modelMapper, DistrictRepository districtRepository, ValidationUtil validationUtil) {
        this.raceRepository = raceRepository;
        this.fileUtil = fileUtil;
        this.raceEntryRepository = raceEntryRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.districtRepository = districtRepository;
        this.validationUtil = validationUtil;
    }


    @Override
    public Boolean racesAreImported() {
        return raceRepository.count() > 0;
    }

    @Override
    public String readRacesXmlFile() throws IOException {
        return fileUtil.readFile(RACES_XML_FILE_PATH);
    }

    @Override
    public String importRaces() throws JAXBException {
        StringBuilder sb = new StringBuilder();

        RaceImportRootDto raceImportRootDtos = xmlParser.parseXml(RaceImportRootDto.class, RACES_XML_FILE_PATH);

        for (RaceImportDto raceImportDto : raceImportRootDtos.getRacerImportDto()) {
            District district = this.districtRepository.findByName(raceImportDto.getDistrict()).orElse(null);

            if (!this.validationUtil.isValid(raceImportDto) || district == null) {

                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            Race race = modelMapper.map(raceImportDto, Race.class);
            race.setDistrict(district);

            List<RaceEntry> raceEntries = new ArrayList<>();

            for (EntryImportDto entryImportDto : raceImportDto.getEntryImportRootDto().getEntryImportDtos()) {
                RaceEntry raceEntry = this.raceEntryRepository.findById(entryImportDto.getId()).orElse(null);

                if (raceEntry == null) {
                    continue;
                }
                raceEntry.setRace(race);
                raceEntries.add(raceEntry);
            }
            race = this.raceRepository.saveAndFlush(race);
            this.raceEntryRepository.saveAll(raceEntries);


            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, race.getClass().getSimpleName(), race.getId()))
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
