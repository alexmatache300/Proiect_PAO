package entitati;

import java.util.List;

public class Profesor extends Persoana{
    private List<Materie> materii;
    private Integer idLocatie;

    public Profesor() {

    }

    @Override
    public String toString() {
        return getNume() + "," +
                getPrenume() + "," +
                materii + "," +
                idLocatie;
    }

    public void setMaterii(List<Materie> materii) {
        this.materii = materii;
    }

    public void setIdLocatie(Integer idLocatie) {
        this.idLocatie = idLocatie;
    }

    public Integer getIdLocatie() {
        return idLocatie;
    }

    public Profesor(String nune, String prenume, List<Materie> materii, Integer idLocatie) {
        super(nune, prenume);
        this.materii = materii;
        this.idLocatie = idLocatie;
    }

    public List<Materie> getMaterii() {
        return materii;
    }

    public Integer getLocatie() {
        return idLocatie;
    }

}
