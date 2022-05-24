package readers;

import entitati.Materie;
import entitati.Profesor;

import dao.MaterieDao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProfesorReader {
    public static ProfesorReader instance = null;
    final private List<Profesor> profesori = new ArrayList<>();

    private ProfesorReader(){}

    public static ProfesorReader getInstance(){
        if(instance == null)
            instance = new ProfesorReader();
        return instance;
    }

    public List<Profesor> getFromCSV(String file, MaterieDao materieDao) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line = data.readLine();

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            List<Materie> materii = new ArrayList<>();
            String [] numeMaterii = Informatii[2].split(" ");

            for (String numeMaterie : numeMaterii) {
                materii.add(materieDao.getMaterie(numeMaterie));
            }

            Profesor elev = new Profesor(Informatii[0], Informatii[1], materii, Integer.parseInt(Informatii[3]));
            this.profesori.add(elev);
        }

        return this.profesori;
    }
}
