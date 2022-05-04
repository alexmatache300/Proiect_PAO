package servici;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Csv_Writer {
    public static Csv_Writer instance = null;

    public static Csv_Writer getInstance(){
        if(instance == null)
            instance = new Csv_Writer();
        return instance;
    }

    private Csv_Writer() {}

    public <T> void writeToFile(String fileName, List<T> objects) throws IOException {
        FileWriter out = new FileWriter(fileName);

        objects.forEach(object -> {
            try {
                out.write(object.toString());
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        });
        out.flush();
    }
}
