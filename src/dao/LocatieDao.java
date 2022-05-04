package dao;

import entitati.Locatie;

import java.util.Map;

public class LocatieDao {
    private Map<Integer, Locatie> locatie_bd;

    public LocatieDao(Map<Integer, Locatie> locatie_bd) {
        this.locatie_bd = locatie_bd;
    }

    public void adauga_locatie(Locatie locatie)
    {
        locatie_bd.put(locatie.getId(), locatie);
    }
}
