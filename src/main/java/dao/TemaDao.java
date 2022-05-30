package dao;

import entitati.Tema;
import repos.TemaRepo;

import java.util.Map;
import java.util.Objects;

public class TemaDao {

    TemaRepo temaRepo;

    public TemaDao(TemaRepo temaRepo) {
        this.temaRepo = temaRepo;
    }

    public void adaugaTema(Tema tema)
    {
        temaRepo.insertTeme(tema);
    }

    public void temaRezolvata(Integer idElev, Integer idTema)
    {
        if (Objects.equals(idElev, temaRepo.readById(idTema).getIdElev()))
        {
            Tema tema = temaRepo.readById(idTema);
            tema.setDone(true);
            temaRepo.updateTema(tema);
        }

    }

    public void evalueazaTema(Integer idTema, Integer nota)
    {
        Tema temaElev = temaRepo.readById(idTema);
        temaElev.setNota(nota);
        temaRepo.updateTema(temaElev);

    }

    public void temaCreata(Tema tema)
    {
        temaRepo.insertTeme(tema);
    }
}
