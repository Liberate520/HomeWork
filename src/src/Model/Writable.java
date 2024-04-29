package src.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public interface Writable {

    void savingToFile(Serializable serializable, String filePath) throws FileNotFoundException, IOException;

    Object fileUpload(File filePath) throws FileNotFoundException, IOException, ClassNotFoundException;
}
