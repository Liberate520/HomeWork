package Notebook.Core.MVP.Models;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;

import Notebook.Core.Models.Recording;
public class FileWriterr {
    public static void writeToFile(String path, Iterable<Recording> iterable) throws Exception {
        String pathProject = System.getProperty("user.dir");
        String pathFile = pathProject.concat(path);
        File file = new File(pathFile);

        try (FileWriter fileWriter = new FileWriter(file)) {
            Iterator<Recording> iterator = iterable.iterator();
            fileWriter.write("[");
            while (iterator.hasNext()) {
                Recording recording = iterator.next();
                String a = "{\"" + recording.getTitle() + "\":\"" + recording.getRecording() + "\"}";
                fileWriter.write(a);
                if (iterator.hasNext()) {
                    fileWriter.write(",\n");
                }
            }
            fileWriter.write("]");
            System.out.println("File saved successfully.");
        } catch (Exception e) {
            throw new Exception("Failed to save file.", e);
        }
    }
}
