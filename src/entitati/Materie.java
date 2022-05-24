package entitati;

import java.util.List;

public class Materie {
    private String numeMaterie;
    private List<String> obiecteEsentiale;
    private Integer id;

    public Materie(String numeMaterie, List<String> obiecteEsentiale) {
        this.numeMaterie = numeMaterie;
        this.obiecteEsentiale = obiecteEsentiale;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }

    public List<String> getObiecteEsentiale() {
        return obiecteEsentiale;
    }

    public String getId() {
        return numeMaterie;
    }
}
