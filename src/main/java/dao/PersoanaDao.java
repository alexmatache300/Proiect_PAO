package dao;

import entitati.Elev;
import entitati.Materie;
import entitati.Persoana;
import entitati.Profesor;
import readers.ElevReader;
import readers.ProfesorReader;
import repos.ElevRepo;
import repos.ProfesorRepo;

import java.util.Map;
import java.util.TreeMap;

public class PersoanaDao {
    ProfesorRepo profesorRepo;
    ElevRepo elevRepo;

    public PersoanaDao(ProfesorRepo profesorRepo, ElevRepo elevRepo) throws Exception {
        this.profesorRepo = profesorRepo;
        this.elevRepo = elevRepo;
    }

    public void adaugaPersoana(Persoana persoana)
    {
        if (persoana instanceof Elev) {
            elevRepo.insertElev((Elev) persoana);
        }
        else if (persoana instanceof Profesor) {
            profesorRepo.insertProfesor((Profesor) persoana);
        }
    }

    public Elev getElev(Integer idElev) { return elevRepo.readById(idElev); }

    public void adaugaMaterieProf(Materie materie, Integer idProfesor)
    {
        Profesor profesor = (Profesor) profesorRepo.readById(idProfesor);
        profesor.getMaterii().add(materie);
        profesorRepo.updateProfesor(profesor);
    }

    public void scoatereMaterieProf(String numeMaterie, Integer idProf)
    {
        Profesor profesor = profesorRepo.readById(idProf);

        for (int i = 0; i < profesor.getMaterii().size(); i++)
        {
            if(numeMaterie.equals(profesor.getMaterii().get(i).getNumeMaterie()))
            {
                profesor.getMaterii().remove(i);
                break;
            }
        }

        profesorRepo.updateProfesor(profesor);
    }

}
