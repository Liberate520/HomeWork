package Model;



import java.io.IOException;

public interface FamilyTreeSerializable {
    void saveFamilyTree(String fileName) throws IOException;
    FamilyTree loadFamilyTree(String fileName) throws IOException, ClassNotFoundException;
}
