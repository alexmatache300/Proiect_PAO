package entitati;

import java.util.Date;

public class Tema {
    private Integer id;
    private Date deadline;
    private Boolean done;
    private Integer nota;
    private Integer idElev;

    public Tema() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setIdElev(Integer idElev) {
        this.idElev = idElev;
    }

    public Date getDeadline() {
        return deadline;
    }

    public Boolean getDone() {
        return done;
    }

    @Override
    public String toString() {
        return  deadline + "," +
                done + "," +
                nota + "," +
                idElev;
    }

    public Tema(Date deadline, Boolean done, Integer idElev) {
        nota = -1;
        this.deadline = deadline;
        this.done = done;
        this.idElev = idElev;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public Integer getIdElev() {
        return idElev;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
