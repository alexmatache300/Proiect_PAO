package dao;

import entitati.Materie;
import entitati.Profesor;

import java.util.Map;

public class MaterieDao {
    private Map<String, Materie> materie_bd;

    public MaterieDao(Map<String, Materie> materie_bd) {
        this.materie_bd = materie_bd;
    }

    public Materie get_materie(String nume_materie){ return materie_bd.get(nume_materie); }

    public void adauga_materie(Materie materie)
    {
        materie_bd.put(materie.getId(), materie);
    }

}
