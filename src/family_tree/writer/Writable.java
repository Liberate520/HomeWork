package family_tree.writer;

import family_tree.tree.FamilyTree;

import java.io.IOException;

public interface Writable {
    public void writeToFamilyTree(FamilyTree obj, String path) throws IOException;
    public FamilyTree readFromFamilyTree(String path) throws IOException, ClassNotFoundException;
}
