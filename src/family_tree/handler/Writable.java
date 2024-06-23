package family_tree.handler;

import family_tree.FamilyTree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Writable {
    void writeClass(FamilyTree familyTree) throws IOException;
    FamilyTree readClass() throws IOException, ClassNotFoundException;

}
