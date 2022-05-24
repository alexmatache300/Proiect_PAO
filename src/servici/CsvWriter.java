package servici;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {
    public static CsvWriter instance = null;

    public static CsvWriter getInstance(){
        if(instance == null)
            instance = new CsvWriter();
        return instance;
    }

    private CsvWriter() {}

    public <T> void writeToFile(String fileName, List<T> objects) throws IOException {
        FileWriter out = new FileWriter(fileName, true);

        objects.stream().forEach(object -> {
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
