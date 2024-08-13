package family_tree.Writer;

import family_tree.family_tree_Angelina.FamilyTree;

public interface WriterHandler {
    void saveFamilyTree (FamilyTree familyTree, String filePath) throws Exception;
    FamilyTree loadFamilyTree(String filePath) throws Exception;
}
