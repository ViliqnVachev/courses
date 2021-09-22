package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.RacerImportDto;
import mostwanted.domain.entities.Racer;
import mostwanted.domain.entities.Town;
import mostwanted.repository.RacerRepository;
import mostwanted.repository.TownRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class RacerServiceImpl implements RacerService {
    private final static String RACERS_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/racers.json";

    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    @Autowired
    public RacerServiceImpl(RacerRepository racerRepository, FileUtil fileUtil, Gson gson, ValidationUtil validationUtil, ModelMapper modelMapper, TownRepository townRepository) {
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public Boolean racersAreImported() {
        return racerRepository.count() > 0;
    }

    @Override
    public String readRacersJsonFile() throws IOException {
        return fileUtil.readFile(RACERS_JSON_FILE_PATH);
    }

    @Override
    public String importRacers(String racersFileContent) {
        StringBuilder sb = new StringBuilder();
        RacerImportDto[] racerImportDtos = gson.fromJson(racersFileContent, RacerImportDto[].class);

        for (RacerImportDto racerImportDto : racerImportDtos) {
            Racer racer = this.racerRepository.findByName(racerImportDto.getName()).orElse(null);
            Town town = this.townRepository.findByName(racerImportDto.getHomeTown()).orElse(null);

            if (racer != null) {
                sb.append(Constants.DUPLICATE_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            if (!this.validationUtil.isValid(racerImportDto) || town == null) {
                sb.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }
            racer = this.modelMapper.map(racerImportDto, Racer.class);
            racer.setHomeTown(town);
            this.racerRepository.saveAndFlush(racer);

            sb.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, racer.getClass().getSimpleName(), racer.getName())).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }

    @Override
    public String exportRacingCars() {
        return null;
    }
}
