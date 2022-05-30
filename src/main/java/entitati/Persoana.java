package entitati;

public class Persoana {
    private String nume;
    private String prenume;
    private  Integer id;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Persoana() {
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public Integer getId() {
        return id;
    }
}
