package FamilyTree.Model.Tree;

import java.io.File;
import java.io.IOException;

public interface Writable {
    void save(FamilyTree tree, File file) throws IOException;

    FamilyTree read(File fileName) throws IOException;
}
