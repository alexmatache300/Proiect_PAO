package entitati;

import java.util.Date;

public class Tema {
    private Date deadline;
    private Boolean done;
    private Integer id;
    private Integer nota;
    private Integer id_elev;

    public Date getDeadline() {
        return deadline;
    }

    public Boolean getDone() {
        return done;
    }

    public Tema(Date deadline, Boolean done, Integer id_elev) {
        nota = -1;
        this.deadline = deadline;
        this.done = done;
        this.id_elev = id_elev;
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

    public Integer getId_elev() {
        return id_elev;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
