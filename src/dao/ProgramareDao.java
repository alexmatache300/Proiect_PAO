package dao;

import entitati.Programare;

import java.util.Map;

public class ProgramareDao {
    private Map<Integer, Programare> programareBd;

    public ProgramareDao(Map<Integer, Programare> programareBd) {
        this.programareBd = programareBd;
    }

    public void adaugaProgramare(Programare programare)
    {
        programareBd.put(programare.getId(), programare);
    }

    public  void anulareProgramareElev(Integer idProgramare)
    {
        Programare programare = programareBd.get(idProgramare);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

    public void metodaAchitare(String plata, Integer idProgramare)
    {
        Programare programare = programareBd.get(idProgramare);
        programare.setPlata(plata);
    }

    public  void anulareProgramareProfesor(Integer idProgramare)
    {
        Programare programare = programareBd.get(idProgramare);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

}
