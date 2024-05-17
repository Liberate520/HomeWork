package file_handler;

import family_tree.FamilyTree;
import java.io.IOException;

public interface Writable {
    void saveTree(FamilyTree familyTree) throws IOException;
    FamilyTree downloadTree() throws IOException, ClassNotFoundException;
}