package entitati;

public class Elev extends Persoana{
    private Integer clasa;

    public Elev() {
        super();
    }

    public void setClasa(Integer clasa) {
        this.clasa = clasa;
    }

    @Override
    public String toString() {
        return  getNume() + "," +
                getPrenume() + "," +
                clasa;
    }

    public Elev(String nume, String prenume, Integer clasa) {
        super(nume, prenume);
        this.clasa = clasa;
    }

    public Integer getClasa() {
        return clasa;
    }

}
