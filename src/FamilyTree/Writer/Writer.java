package FamilyTree.Writer;

import FamilyTree.familyTree.*;
public interface Writer {
    void save(FamilyTree familyTree, String filename);
    FamilyTree load(String filename);
}
