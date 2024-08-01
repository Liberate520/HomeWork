package familyTree.writer;

import familyTree.familyTree.FamilyTree;
import familyTree.human.People;

import java.io.IOException;
import java.util.List;

public interface Writer {
    void saveFamilyTree(String nameFile, List<People> tree) throws IOException;
    FamilyTree loadFamilyTree(String nameFile) throws IOException, ClassNotFoundException;
}
