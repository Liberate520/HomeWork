package GenerationTree.Model.FileHandler;

import java.io.Serializable;

public interface FileWriter {
    boolean save(Serializable serializable, String filePath);
}