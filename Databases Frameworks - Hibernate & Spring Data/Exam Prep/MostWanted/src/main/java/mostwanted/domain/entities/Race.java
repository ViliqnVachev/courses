package mostwanted.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "races")
public class Race {
    private Integer id;
    private Integer laps;
    private District district;
    private List<RaceEntry> entries;

    public Race() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "laps", nullable = false, columnDefinition = "INT(11) default 0")
    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    @ManyToOne(targetEntity = District.class)
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @OneToMany(targetEntity = RaceEntry.class, mappedBy = "race")
    public List<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(List<RaceEntry> entries) {
        this.entries = entries;
    }
}
