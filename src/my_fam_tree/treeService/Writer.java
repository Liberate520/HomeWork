package my_fam_tree.treeService;

import my_fam_tree.structure.FamilyTree;

import java.io.IOException;

public interface Writer  {
    void saveToFile(String fileName, FamilyTree<?> familyTree) throws IOException;
    FamilyTree<?> loadFromFile(String fileName) throws IOException, ClassNotFoundException;
}
