package Model.Formating.Writer;

import Model.FamilyTree.Save;

import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    void save(Save save) throws IOException;

    String getDirName();

    Save open(String name) throws IOException, ClassNotFoundException;

    public ArrayList<String> getSavesList();
}
