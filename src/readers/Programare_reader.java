package readers;

import entitati.Programare;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;


public class Programare_reader {
    public static Programare_reader instance = null;
    final private List<Programare> programari = new ArrayList<>();

    private Programare_reader(){}

    public static Programare_reader getInstance(){
        if(instance == null)
            instance = new Programare_reader();
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
