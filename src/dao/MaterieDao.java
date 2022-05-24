package dao;

import entitati.Materie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MaterieDao {
    private Map<String, Materie> materieBd;

    public MaterieDao(Map<String, Materie> materieBd) {
        this.materieBd = materieBd;
        List<String> obiecte = new ArrayList<>();
        obiecte.add("rigla");
        obiecte.add("echer");
        adaugaMaterie(new Materie("mate", obiecte));
        obiecte.clear();
        obiecte.add("creion");
        obiecte.add("guma");
        adaugaMaterie(new Materie("fizica", obiecte));
        adaugaMaterie(new Materie("informatica", obiecte));
        adaugaMaterie(new Materie("chimie", obiecte));
        adaugaMaterie(new Materie("biologie", obiecte));
        obiecte.clear();
    }

    public Materie getMaterie(String numeMaterie){ return materieBd.get(numeMaterie); }

    public void adaugaMaterie(Materie materie)
    {
        materieBd.put(materie.getId(), materie);
    }

}
