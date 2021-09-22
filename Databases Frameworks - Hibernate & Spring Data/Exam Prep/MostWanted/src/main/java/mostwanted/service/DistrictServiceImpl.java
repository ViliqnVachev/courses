package mostwanted.service;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.DistrictImportDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Town;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.TownRepository;
import mostwanted.util.FileUtil;
import mostwanted.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DistrictServiceImpl implements DistrictService {
    private final static String DISTRICTS_JSON_FILE_PATH = System.getProperty("user.dir") + "/src/main/resources/files/districts.json";

    private final DistrictRepository districtRepository;
    private final FileUtil fileUtil;
    private final TownRepository townRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;

    public DistrictServiceImpl(DistrictRepository districtRepository, FileUtil fileUtil, TownRepository townRepository, ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson) {
        this.districtRepository = districtRepository;
        this.fileUtil = fileUtil;
        this.townRepository = townRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public Boolean districtsAreImported() {
        return districtRepository.count() > 0;
    }

    @Override
    public String readDistrictsJsonFile() throws IOException {
        return fileUtil.readFile(DISTRICTS_JSON_FILE_PATH);
    }

    @Override
    public String importDistricts(String districtsFileContent) {
        StringBuilder importResult = new StringBuilder();

        DistrictImportDto[] districtImportDtos = gson.fromJson(districtsFileContent, DistrictImportDto[].class);

        for (DistrictImportDto districtImportDto : districtImportDtos) {
            District district = this.districtRepository.findByName(districtImportDto.getName()).orElse(null);
            if (district != null) {
                importResult.append(Constants.DUPLICATE_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }

            Town town = this.townRepository.findByName(districtImportDto.getTownName()).orElse(null);
            if (!this.validationUtil.isValid(districtImportDto) || town == null) {
                importResult.append(Constants.INCORRECT_DATA_MESSAGE).append(System.lineSeparator());
                continue;
            }


            district = modelMapper.map(districtImportDto, District.class);
            district.setTown(town);
            this.districtRepository.saveAndFlush(district);

            importResult.append(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE, district.getClass().getSimpleName(), district.getName())).append(System.lineSeparator());

        }

        return importResult.toString().trim();
    }
}
