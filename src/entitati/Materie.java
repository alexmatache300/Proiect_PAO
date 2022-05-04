package entitati;

import java.io.Serializable;
import java.util.List;

public class Materie {
    private String nume_materie;
    private List<String> obiecte_esentiale;
    private Integer id;

    public Materie(String nume_materie, List<String> obiecte_esentiale) {
        this.nume_materie = nume_materie;
        this.obiecte_esentiale = obiecte_esentiale;
    }

    public String getNume_materie() {
        return nume_materie;
    }

    public List<String> getObiecte_esentiale() {
        return obiecte_esentiale;
    }

    public String getId() {
        return nume_materie;
    }
}
