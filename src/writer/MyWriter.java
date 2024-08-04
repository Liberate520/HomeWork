package writer;

import family_tree.FamilyTree;

public interface MyWriter {
    boolean save(FamilyTree familyTree);

    FamilyTree load();
}
