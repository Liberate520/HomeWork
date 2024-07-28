package Writers;

import model.FamilyTree.FamilyTree;
import model.Humans.Human;

import java.io.Serializable;



public interface Writer {
    boolean save(FamilyTree<Human> familyTree);
    FamilyTree<Human> read();
    void setFilePath(String filePath);
}
