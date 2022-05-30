package entitati;

import java.util.Date;

public class Programare {

    private Integer idProfesor;
    private Integer idElev;
    private Date zi;
    private Integer id;
    private Boolean anulata;
    private String plata;

    public Programare() {

    }

    @Override
    public String toString() {
        return idProfesor +
                "," + idElev +
                "," + zi +
                "," + id +
                "," + anulata +
                "," + plata;
    }

    public Programare(Integer idProfesor, Integer idElev, Date zi, Integer id, String plata) {
        this.idProfesor = idProfesor;
        this.idElev = idElev;
        this.zi = zi;
        this.id = id;
        this.anulata = false;
        this.plata = plata;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public void setIdElev(Integer idElev) {
        this.idElev = idElev;
    }

    public void setZi(Date zi) {
        this.zi = zi;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProfesor() {
        return idProfesor;
    }

    public Integer getElev() {
        return idElev;
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

    public Boolean getAnulata() {
        return anulata;
    }

    public void setPlata(String plata) {
        this.plata = plata;
    }

    public void setAnulata(Boolean anulata) {
        this.anulata = anulata;
    }


}
