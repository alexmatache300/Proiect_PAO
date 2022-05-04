package entitati;

import java.time.DayOfWeek;
import java.util.List;

public class Grupa {
    private List<Elev> elevi;
    private DayOfWeek zi_grupa;
    private Integer id;

    public List<Elev> getElevi() {
        return elevi;
    }

    public DayOfWeek getZi_grupa() {
        return zi_grupa;
    }

    public Grupa(List<Elev> elevi, DayOfWeek zi_grupa) {
        this.elevi = elevi;
        this.zi_grupa = zi_grupa;
    }

    public Integer getId() {
        return id;
    }
}
