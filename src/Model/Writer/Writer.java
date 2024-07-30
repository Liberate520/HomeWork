package Model.Writer;
import Model.FamilyTree.Tree;

import java.io.IOException;

public interface Writer {
    void save(Tree familyTree, String name) throws IOException;

    String getDirName();

    Tree open(String name) throws IOException, ClassNotFoundException;
}
