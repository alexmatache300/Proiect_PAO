package entitati;

public class Elev extends Persoana{
    private Integer clasa;

    public Elev(String nume, String prenume, Integer clasa) {
        super(nume, prenume);
        this.clasa = clasa;
    }

    public Integer getClasa() {
        return clasa;
    }

}
