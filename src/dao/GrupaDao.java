package dao;

import entitati.Elev;
import entitati.Grupa;

import java.util.Map;

public class GrupaDao {
    private Map<Integer, Grupa> grupa_bd;

    public GrupaDao(Map<Integer, Grupa> grupa_bd) {
        this.grupa_bd = grupa_bd;
    }

    public void adauga_grupa(Grupa grupa)
    {
        grupa_bd.put(grupa.getId(), grupa);
    }

    public  void adauga_elev(Elev elev, Integer id_grupa) { grupa_bd.get(id_grupa).getElevi().add(elev); }

}
