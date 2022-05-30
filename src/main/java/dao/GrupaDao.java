package dao;

import entitati.Elev;
import entitati.Grupa;

import java.util.Map;

public class GrupaDao {
    private Map<Integer, Grupa> grupaBd;

    public GrupaDao(Map<Integer, Grupa> grupaBd) {
        this.grupaBd = grupaBd;
    }

    public void adaugaGrupa(Grupa grupa)
    {
        grupaBd.put(grupa.getId(), grupa);
    }

    public  void adaugaElev(Elev elev, Integer idGrupa) { grupaBd.get(idGrupa).getElevi().add(elev); }

}
