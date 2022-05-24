package entitati;

import java.util.Date;

public class Programare {

    private Integer idProfesor;
    private Integer id_elev;
    private Date zi;
    private Integer id;
    private Boolean anulata;
    private String plata;

    @Override
    public String toString() {
        return idProfesor +
                "," + id_elev +
                "," + zi +
                "," + id +
                "," + anulata +
                "," + plata;
    }

    public Programare(Integer idProfesor, Integer id_elev, Date zi, Integer id, String plata) {
        this.idProfesor = idProfesor;
        this.id_elev = id_elev;
        this.zi = zi;
        this.id = id;
        this.anulata = false;
        this.plata = plata;
    }

    public Integer getProfesor() {
        return idProfesor;
    }

    public Integer getElev() {
        return id_elev;
    }

    public Date getZi() {
        return zi;
    }

    public Integer getId() {
        return id;
    }

    public String getPlata() {
        return plata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }

    public void setAnulata(Boolean anulata) {
        this.anulata = anulata;
    }


}
