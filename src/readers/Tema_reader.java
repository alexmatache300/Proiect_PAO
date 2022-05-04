package readers;

import entitati.Elev;
import entitati.Tema;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Tema_reader {
    public static Tema_reader instance = null;
    final private List<Tema> teme = new ArrayList<>();

    private Tema_reader(){}

    public static Tema_reader getInstance(){
        if(instance == null)
            instance = new Tema_reader();
        return instance;
    }

    public List<Tema> getFromCSV(String file) throws Exception {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line;

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            Tema tema = new Tema(new SimpleDateFormat("yyyy-MM-dd").parse(Informatii[0]), Boolean.parseBoolean(Informatii[1]), Integer.parseInt(Informatii[2]));
            this.teme.add(tema);
        }

        return this.teme;
    }
}
