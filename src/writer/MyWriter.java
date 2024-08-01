package writer;

import family_tree.FamilyTree;

public interface MyWriter {
    boolean save(FamilyTree familyTree);

    boolean load(FamilyTree familyTree);
}
