package dao;

import entitati.Programare;
import repos.ProfesorRepo;
import repos.ProgramareRepo;

import java.util.Map;

public class ProgramareDao {
    ProgramareRepo programareRepo;

    public ProgramareDao(ProgramareRepo programareRepo) {
        this.programareRepo = programareRepo;
    }

    public void adaugaProgramare(Programare programare)
    {
        programareRepo.insertProgramare(programare);
    }

    public  void anulareProgramareElev(Integer idProfesor, Integer idElev)
    {
        Programare programare = programareRepo.readById(idProfesor,idElev);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

    public void metodaAchitare(String plata, Integer idProfesor, Integer idElev)
    {
        Programare programare = programareRepo.readById(idProfesor,idElev);
        programare.setPlata(plata);
    }

    public  void anulareProgramareProfesor(Integer idProfesor, Integer idElev)
    {
        Programare programare = programareRepo.readById(idProfesor,idElev);
        if (programare != null)
        {
            programare.setAnulata(true);
        }
    }

}
