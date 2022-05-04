package dao;

import entitati.Elev;
import entitati.Tema;

import java.util.Map;

public class TemaDao {
    private Map<Integer, Tema> tema_bd;

    public TemaDao(Map<Integer, Tema> tema_bd) {
        this.tema_bd = tema_bd;
    }

    public void adauga_tema(Tema tema)
    {
        tema_bd.put(tema.getId(), tema);
    }

    public void tema_rezolvata(Integer id_elev, Integer id_tema)
    {
        if (id_elev == tema_bd.get(id_tema).getId_elev())
        {
            tema_bd.get(id_tema).setDone(true);
        }
    }

    public void evalueaza_tema(Integer id_tema, Integer nota)
    {
        Tema tema_elev = tema_bd.get(id_tema);
        tema_elev.setNota(nota);
    }

    public void tema_creata(Tema tema)
    {
        tema_bd.put(tema.getId(), tema);
    }
}
