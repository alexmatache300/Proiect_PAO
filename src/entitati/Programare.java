package entitati;

import java.sql.Time;
import java.util.Date;

public class Programare {

    private Integer id_profesor;
    private Integer id_elev;
    private Date zi;
    private Integer id;
    private Boolean anulata;
    private String plata;

    public Programare(Integer id_profesor, Integer id_elev, Date zi, Integer id, String plata) {
        this.id_profesor = id_profesor;
        this.id_elev = id_elev;
        this.zi = zi;
        this.id = id;
        this.anulata = false;
        this.plata = plata;
    }

    public Integer getProfesor() {
        return id_profesor;
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
