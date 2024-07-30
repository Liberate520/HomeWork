package FamilyTree.utility;

import FamilyTree.model.FamilyTree;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);

    FamilyTree load();

    void setPath(String filePath);
}