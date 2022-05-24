package entitati;

import java.util.List;

public class Profesor extends Persoana{
    private List<Materie> materii;
    private Integer idLocatie;

    @Override
    public String toString() {
        return getNune() + "," +
                getPrenume() + "," +
                materii + "," +
                idLocatie;
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
