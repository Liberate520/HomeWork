package FamilyTree.writer;

import FamilyTree.familyTree.*;

import java.io.Serializable;

public interface Writer {
    void save(Serializable serializable);
    FamilyTree load();

    void setPath(String filePath);
}
