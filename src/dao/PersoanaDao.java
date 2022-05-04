package dao;

import entitati.Elev;
import entitati.Materie;
import entitati.Persoana;
import entitati.Profesor;
import readers.Elev_reader;
import readers.Profesor_reader;

import java.util.Map;
import java.util.TreeMap;

public class PersoanaDao {
    private Map<Integer, Persoana> persoana_bd;

    public PersoanaDao(Map<Integer, Persoana> persoana_bd) throws Exception{
        this.persoana_bd = persoana_bd;
        Elev_reader.getInstance().getFromCSV("src/Csv/Elev.csv");
        Profesor_reader.getInstance().getFromCSV("src/Csv/Profesor.csv", new MaterieDao(new TreeMap<>()));
}

    public void adauga_persoana(Persoana persoana)
    {
        persoana_bd.put(persoana.getId(), persoana);
    }

    public Elev get_elev(Integer id_elev) { return (Elev) persoana_bd.get(id_elev); }

    public void adauga_materie_prof(Materie materie, Integer id_profesor)
    {
        Profesor profesor = (Profesor) persoana_bd.get(id_profesor);
        profesor.getMaterii().add(materie);
    }

    public void scoatere_materie_prof (String nume_materie, Integer id_prof)
    {
        Profesor profesor = (Profesor) persoana_bd.get(id_prof);
        for (int i = 0; i < profesor.getMaterii().size(); i++)
        {
            if(nume_materie == profesor.getMaterii().get(i).getNume_materie())
            {
                profesor.getMaterii().remove(i);
                break;
            }
        }
    }

}
