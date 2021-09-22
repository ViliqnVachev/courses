package mostwanted.domain.dtos.races;

import mostwanted.domain.dtos.RacerImportDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportRootDto {
    @XmlElement(name = "race")
    private RaceImportDto[] raceImportDto;

    public RaceImportRootDto() {
    }

    public RaceImportDto[] getRacerImportDto() {
        return raceImportDto;
    }

    public void setRacerImportDto(RaceImportDto[] racerImportDto) {
        this.raceImportDto = racerImportDto;
    }
}
