package dao;

import entitati.Elev;
import entitati.Materie;
import entitati.Persoana;
import entitati.Profesor;
import readers.ElevReader;
import readers.ProfesorReader;

import java.util.Map;
import java.util.TreeMap;

public class PersoanaDao {
    private Map<Integer, Persoana> persoanaBd;

    public PersoanaDao(Map<Integer, Persoana> persoanaBd) throws Exception{
        this.persoanaBd = persoanaBd;
        ElevReader.getInstance().getFromCSV("src/Csv/Elev.csv");
        ProfesorReader.getInstance().getFromCSV("src/Csv/Profesor.csv", new MaterieDao(new TreeMap<>()));
}

    public void adaugaPersoana(Persoana persoana)
    {
        persoanaBd.put(persoana.getId(), persoana);
    }

    public Elev getElev(Integer idElev) { return (Elev) persoanaBd.get(idElev); }

    public void adaugaMaterieProf(Materie materie, Integer idProfesor)
    {
        Profesor profesor = (Profesor) persoanaBd.get(idProfesor);
        profesor.getMaterii().add(materie);
    }

    public void scoatereMaterieProf(String numeMaterie, Integer idProf)
    {
        Profesor profesor = (Profesor) persoanaBd.get(idProf);
        for (int i = 0; i < profesor.getMaterii().size(); i++)
        {
            if(numeMaterie == profesor.getMaterii().get(i).getNumeMaterie())
            {
                profesor.getMaterii().remove(i);
                break;
            }
        }
    }

}
