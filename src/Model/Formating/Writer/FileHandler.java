package Model.Formating.Writer;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTree.Save;

import java.io.*;

public class FileHandler implements Writer {
    private final String dirName = "src\\Data";

    private String create_name(String name){
        return dirName + "\\" + name;
    }

    public String getDirName() {
        return dirName;
    }

    public void save(Save save) throws IOException {
        ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(create_name(save.getFileName())));

        data.writeObject(save);

        data.close();
    }

    public Save open(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(new FileInputStream(create_name(name)));

        Save save = (Save) object.readObject();

        object.close();

        return save;
    }
}
