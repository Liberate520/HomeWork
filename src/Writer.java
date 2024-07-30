import java.io.IOException;

public interface Writer {
    void saveFamilyTree(FamilyTree familyTree, String filename) throws IOException;
    FamilyTree loadFamilyTree(String filename) throws IOException, ClassNotFoundException;
}