package dao;

import entitati.Locatie;

import java.util.Map;

public class LocatieDao {
    private Map<Integer, Locatie> locatieBd;

    public LocatieDao(Map<Integer, Locatie> locatieBd) {
        this.locatieBd = locatieBd;
    }

    public void adaugaLocatie(Locatie locatie)
    {
        locatieBd.put(locatie.getId(), locatie);
    }
}
