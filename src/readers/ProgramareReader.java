package readers;

import entitati.Programare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ProgramareReader {
    public static ProgramareReader instance = null;
    final private List<Programare> programari = new ArrayList<>();

    private ProgramareReader(){}

    public static ProgramareReader getInstance(){
        if(instance == null)
            instance = new ProgramareReader();
        return instance;
    }

    public List<Programare> getFromCSV(String file) throws Exception {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line;

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            Programare programare = new Programare(Integer.parseInt(Informatii[0]), Integer.parseInt(Informatii[1]), new SimpleDateFormat("yyyy-MM-dd").parse(Informatii[3]), Integer.parseInt(Informatii[4]), Informatii[5]);
            this.programari.add(programare);
        }

        return this.programari;
    }
}
