package servici;

import dao.*;
import entitati.Materie;
import entitati.Tema;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ServiciiProfesor {

    private ProgramareDao programareDao;
    private GrupaDao grupaDao;
    private PersoanaDao persoanaDao;
    private TemaDao temaDao;
    private MaterieDao materieDao;


    public void evaluareTema(Integer idTema, Integer nota)
    {
        temaDao.evalueazaTema(idTema, nota);
    }

    public void creareTema(Date deadline, Boolean done, Integer idElev)
    {
        Tema tema = new Tema(deadline, done, idElev);
        temaDao.temaCreata(tema);
        try
        {
            List<Tema> listaTema = new ArrayList<>();
            listaTema.add(tema);
            CsvWriter.getInstance().writeToFile("src/Csv/teme.csv", listaTema);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void anulareProgramare(Integer idProfesor, Integer idElev)
    {
        programareDao.anulareProgramareProfesor(idProfesor, idElev);
    }

    public void adaugareMaterieDePredare(String numeMaterie, Integer idProfesor)
    {
        Materie materie = MaterieDao.getMaterie(numeMaterie);
        persoanaDao.adaugaMaterieProf(materie, idProfesor);
    }

    public void scoatereMaterieDePredare(String numeMaterie, Integer idProf)
    {
        persoanaDao.scoatereMaterieProf(numeMaterie, idProf);
    }

    public ServiciiProfesor(ProgramareDao programareDao, GrupaDao grupaDao, PersoanaDao persoanaDao, TemaDao temaDao, MaterieDao materieDao) {
        this.programareDao = programareDao;
        this.grupaDao = grupaDao;
        this.persoanaDao = persoanaDao;
        this.temaDao = temaDao;
        this.materieDao = materieDao;
    }
}
