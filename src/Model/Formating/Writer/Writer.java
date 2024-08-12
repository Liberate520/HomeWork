package Model.Formating.Writer;

import Model.FamilyTree.Save;

import java.io.IOException;

public interface Writer {
    void save(Save save) throws IOException;

    String getDirName();

    Save open(String name) throws IOException, ClassNotFoundException;
}
