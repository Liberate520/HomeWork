package famyilyTree;

public interface MakeFiles {
    void saveToFile (FamilyTree tree, String filename);
    FamilyTree loadFromFile (String filename);
}
