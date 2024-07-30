package Model.Writer;
import Model.FamilyTree.Tree;

import java.io.*;

public class FileHandler implements Writer {
    private final String dirName = "src\\Data";

    private String create_name(String name){
        return dirName + "\\" + name;
    }

    public String getDirName() {
        return dirName;
    }

    public void save(Tree familyTree, String name) throws IOException {
        ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(create_name(name)));

        data.writeObject(familyTree);

        data.close();
    }

    public Tree open(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(new FileInputStream(create_name(name)));

        Tree familyTree = (Tree) object.readObject();

        object.close();

        return familyTree;
    }
}
