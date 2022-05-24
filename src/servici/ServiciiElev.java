package servici;

import dao.GrupaDao;
import dao.PersoanaDao;
import dao.ProgramareDao;
import dao.TemaDao;
import entitati.Programare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiciiElev {
    private ProgramareDao programareDao;
    private GrupaDao grupaDao;
    private PersoanaDao persoanaDao;
    private TemaDao temaDao;

    public void creareProgramare(Integer idProfesor , Integer idElev , Date zi , Integer id, String plata)
    {
        Programare programare = new Programare(idProfesor , idElev , zi , id, plata);
        programareDao.adaugaProgramare(programare);
        try
        {
            List<Programare> lista = new ArrayList<>();
            lista.add(programare);
            CsvWriter.getInstance().writeToFile("src/Csv/Programare.csv", lista);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inscriereInGrupa(Integer idElev, Integer idGrupa)
    {
        grupaDao.adaugaElev(persoanaDao.getElev(idElev), idGrupa);
    }

    public void temaCompletata(Integer idElev, Integer idTema)
    {
        temaDao.temaRezolvata(idElev, idTema);
    }

    public void anulareProgramare(Integer idProgramare)
    {
        programareDao.anulareProgramareElev(idProgramare);
    }

    public void metodaPlata(String plata, Integer idProgramare)
    {
        programareDao.metodaAchitare(plata, idProgramare);
    }

    public ServiciiElev(ProgramareDao programareDao, GrupaDao grupaDao, PersoanaDao persoanaDao, TemaDao temaDao) {
        this.programareDao = programareDao;
        this.grupaDao = grupaDao;
        this.persoanaDao = persoanaDao;
        this.temaDao = temaDao;
    }
}
