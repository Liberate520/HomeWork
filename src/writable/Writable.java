package writable;

import family_tree.FamilyTree;

public interface Writable {
    void write(FamilyTree familyTree);
    FamilyTree load();

}
