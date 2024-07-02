package Writer;

import Tree.FamilyTree;

import java.io.IOException;

public interface Writer {
    String create_name(String name);

    void writeFile(FamilyTree familyTree, String name) throws IOException;

    FamilyTree readFile(String name) throws IOException, ClassNotFoundException;
}
