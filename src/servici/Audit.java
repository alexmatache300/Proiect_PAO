package servici;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Audit {
    FileWriter writer;

    public Audit(String file_Name) throws Exception {
        this.writer = new FileWriter(file_Name);
    }

    public void logAction(String comm) throws Exception {
        writer.append(comm);
        writer.append(", ");
        writer.append(LocalDate.now().toString());
        writer.append(", ");
        writer.append(LocalTime.now().toString());
        writer.append("\n");
        writer.flush();
    }
}
