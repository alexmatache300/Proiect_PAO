package dao;

import entitati.Programare;

import java.util.Map;

public class ProgramareDao {
    private Map<Integer, Programare> programare_bd;

    public ProgramareDao(Map<Integer, Programare> programare_bd) {
        this.programare_bd = programare_bd;
    }

    public void adauga_programare(Programare programare)
    {
        programare_bd.put(programare.getId(), programare);
    }

    public  void anulare_programare_elev(Integer id_programare)
    {
        Programare programare = programare_bd.get(id_programare);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

    public void metoda_achitare(String plata, Integer id_programare)
    {
        Programare programare = programare_bd.get(id_programare);
        programare.setPlata(plata);
    }

    public  void anulare_programare_profesor(Integer id_programare)
    {
        Programare programare = programare_bd.get(id_programare);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

}
