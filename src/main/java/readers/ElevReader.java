package readers;

import entitati.Elev;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ElevReader {
    public static ElevReader instance = null;
    final private List<Elev> elevi = new ArrayList<>();

    private ElevReader(){}

    public static ElevReader getInstance(){
        if(instance == null)
            instance = new ElevReader();
        return instance;
    }

    public List<Elev> getFromCSV(String file) throws IOException {
        BufferedReader data = new BufferedReader(new FileReader(file));
        String line = data.readLine();

        while((line =  data.readLine()) != null){
            String [] Informatii = line.split(",");
            Elev elev = new Elev(Informatii[0], Informatii[1], Integer.parseInt(Informatii[2]));
            this.elevi.add(elev);
        }

        return this.elevi;
    }
}
