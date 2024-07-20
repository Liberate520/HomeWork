package Model.Interface;

import java.io.IOException;

public interface Writer {
    String create_name(String name);

    void writeFile(FamilyTreeInterface<?> familyTree, String name) throws IOException;

    FamilyTreeInterface<?> readFile(String name) throws IOException, ClassNotFoundException;
}
