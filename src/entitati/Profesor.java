package entitati;

import java.util.List;

public class Profesor extends Persoana{
    private List<Materie> materii;
    private Integer id_locatie;

    public Profesor(String nune, String prenume, List<Materie> materii, Integer id_locatie) {
        super(nune, prenume);
        this.materii = materii;
        this.id_locatie = id_locatie;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public Integer getLocatie() {
        return id_locatie;
    }

}
