package servici;

import dao.GrupaDao;
import dao.PersoanaDao;
import dao.ProgramareDao;
import dao.TemaDao;
import entitati.Programare;

import java.sql.Time;
import java.util.Date;

public class ServiciiElev {
    private ProgramareDao programareDao;
    private GrupaDao grupaDao;
    private PersoanaDao persoanaDao;
    private TemaDao temaDao;

    public void creare_programare(Integer id_profesor , Integer id_elev , Date zi , Integer id, String plata)
    {
        Programare programare = new Programare(id_profesor , id_elev , zi , id, plata);
        programareDao.adauga_programare(programare);
    }

    public void inscriere_in_grupa(Integer id_elev, Integer id_grupa)
    {
        grupaDao.adauga_elev(persoanaDao.get_elev(id_elev), id_grupa);
    }

    public void tema_completata(Integer id_elev, Integer id_tema)
    {
        temaDao.tema_rezolvata(id_elev, id_tema);
    }

    public void anulare_programare(Integer id_programare)
    {
        programareDao.anulare_programare_elev(id_programare);
    }

    public void metoda_plata(String plata, Integer id_programare)
    {
        programareDao.metoda_achitare(plata, id_programare);
    }

    public ServiciiElev(ProgramareDao programareDao, GrupaDao grupaDao, PersoanaDao persoanaDao, TemaDao temaDao) {
        this.programareDao = programareDao;
        this.grupaDao = grupaDao;
        this.persoanaDao = persoanaDao;
        this.temaDao = temaDao;
    }
}
