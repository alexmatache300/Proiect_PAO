package dao;

import entitati.Materie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaterieDao {
    private static Map<String, Materie> materieBd = new TreeMap<String, Materie>();

    public <K, V> MaterieDao(TreeMap<K,V> kvTreeMap) {
    }

    public static void init() {
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

    public static Materie getMaterie(String numeMaterie){ return materieBd.get(numeMaterie); }

    public static void adaugaMaterie(Materie materie)
    {
        materieBd.put(materie.getId(), materie);
    }

}
