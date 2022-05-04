package readers;

import entitati.Materie;
import entitati.Profesor;

import dao.MaterieDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Profesor_reader {
    public static Profesor_reader instance = null;
    final private List<Profesor> profesori = new ArrayList<>();

    private Profesor_reader(){}

    public static Profesor_reader getInstance(){
        if(instance == null)
            instance = new Profesor_reader();
        return instance;
    }

    public List<Profesor> getFromCSV(String file, MaterieDao materieDao) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line;

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            List<Materie> materii = new ArrayList<>();

            for (int i = 3; i < Informatii.length; i++) {
                materii.add(materieDao.get_materie(Informatii[i]));
            }
            Profesor elev = new Profesor(Informatii[0], Informatii[1], materii, Integer.parseInt(Informatii[2]));
            this.profesori.add(elev);
        }

        return this.profesori;
    }
}
