package familyTree.model.FileHandler;

import java.io.Serializable;

public interface Writer {
    boolean saveFile(Serializable serializable);

    Object openFile();

    void setFileName(String fileName);
}
