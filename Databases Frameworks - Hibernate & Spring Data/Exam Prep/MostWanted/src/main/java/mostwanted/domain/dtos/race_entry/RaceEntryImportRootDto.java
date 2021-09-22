package mostwanted.domain.dtos.race_entry;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryImportRootDto {

    @XmlElement(name = "race-entry")
    private RaceEntryImportDto[] raceEntryImportDto;

    public RaceEntryImportRootDto() {
    }

    public RaceEntryImportDto[] getRaceEntryImportDto() {
        return raceEntryImportDto;
    }

    public void setRaceEntryImportDto(RaceEntryImportDto[] raceEntryImportDto) {
        this.raceEntryImportDto = raceEntryImportDto;
    }
}
