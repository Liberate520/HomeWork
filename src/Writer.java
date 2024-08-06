import java.io.IOException;

public interface Writer<T extends FamilyMember> {
    void saveFamilyTree(FamilyTree<T> familyTree, String filename) throws IOException;
    FamilyTree<T> loadFamilyTree(String filename) throws IOException, ClassNotFoundException;
}