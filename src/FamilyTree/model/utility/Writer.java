package FamilyTree.model.utility;

import FamilyTree.model.familyTree.FamilyTree;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);

    FamilyTree load();

    void setPath(String filePath);
}