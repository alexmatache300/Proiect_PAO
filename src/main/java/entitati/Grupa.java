package entitati;

import java.time.DayOfWeek;
import java.util.List;

public class Grupa {
    private List<Elev> elevi;
    private DayOfWeek ziGrupa;
    private Integer id;

    public List<Elev> getElevi() {
        return elevi;
    }

    public DayOfWeek getZiGrupa() {
        return ziGrupa;
    }

    public Grupa(List<Elev> elevi, DayOfWeek ziGrupa) {
        this.elevi = elevi;
        this.ziGrupa = ziGrupa;
    }

    public Integer getId() {
        return id;
    }
}
