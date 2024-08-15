package GB_FamilyTree.Family_Tree.FileManager;

import java.io.Serializable;

public interface Writer {
    boolean save(Serializable serializable);

    Object read();

    void setPath(String filePath);
}
