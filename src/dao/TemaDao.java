package dao;

import entitati.Tema;

import java.util.Map;

public class TemaDao {
    private Map<Integer, Tema> temaBd;

    public TemaDao(Map<Integer, Tema> temaBd) {
        this.temaBd = temaBd;
    }

    public void adaugaTema(Tema tema)
    {
        temaBd.put(tema.getId(), tema);
    }

    public void temaRezolvata(Integer idElev, Integer idTema)
    {
        if (idElev == temaBd.get(idTema).getIdElev())
        {
            temaBd.get(idTema).setDone(true);
        }
    }

    public void evalueazaTema(Integer idTema, Integer nota)
    {
        Tema temaElev = temaBd.get(idTema);
        temaElev.setNota(nota);
    }

    public void temaCreata(Tema tema)
    {
        temaBd.put(tema.getId(), tema);
    }
}
