package servici;

import dao.*;
import entitati.Materie;
import entitati.Programare;
import entitati.Tema;

import java.sql.Time;
import java.util.Date;


public class ServiciiProfesor {

    private ProgramareDao programareDao;
    private GrupaDao grupaDao;
    private PersoanaDao persoanaDao;
    private TemaDao temaDao;
    private MaterieDao materieDao;


    public void evaluare_tema(Integer id_tema, Integer nota)
    {
        temaDao.evalueaza_tema(id_tema, nota);
    }

    public void creare_tema(Date deadline, Boolean done, Integer id_elev)
    {
        Tema tema = new Tema(deadline, done, id_elev);
        temaDao.tema_creata(tema);
    }

    public void anulare_programare(Integer id_programare)
    {
        programareDao.anulare_programare_profesor(id_programare);
    }

    public void adaugare_materie_de_predare(String nume_materie, Integer id_profesor)
    {
        Materie materie = materieDao.get_materie(nume_materie);
        persoanaDao.adauga_materie_prof(materie, id_profesor);
    }

    public void scoatere_materie_de_predare(String nume_materie, Integer id_prof)
    {
        persoanaDao.scoatere_materie_prof(nume_materie, id_prof);
    }

    public ServiciiProfesor(ProgramareDao programareDao, GrupaDao grupaDao, PersoanaDao persoanaDao, TemaDao temaDao, MaterieDao materieDao) {
        this.programareDao = programareDao;
        this.grupaDao = grupaDao;
        this.persoanaDao = persoanaDao;
        this.temaDao = temaDao;
        this.materieDao = materieDao;
    }
}
