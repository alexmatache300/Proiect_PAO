package entitati;

public class Persoana {
    private String nune;
    private String prenume;
    private  Integer id;

    public Persoana(String nune, String prenume) {
        this.nune = nune;
        this.prenume = prenume;
    }

    public String getNune() {
        return nune;
    }

    public String getPrenume() {
        return prenume;
    }

    public Integer getId() {
        return id;
    }
}
