package Model.Writer;

import Model.Interface.FamilyTreeInterface;
import Model.Interface.Writer;

import java.io.*;

public class FileHandler implements Writer {
    private static final String dirName = "src\\Data\\";

    @Override
    public String create_name(String name){
        return dirName + name;
    }

    @Override
    public void writeFile(FamilyTreeInterface<?> familyTree, String name) throws IOException {
        ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(create_name(name)));

        data.writeObject(familyTree);

        data.close();
    }

    @Override
    public FamilyTreeInterface<?> readFile(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(new FileInputStream(create_name(name)));

        FamilyTreeInterface<?> familyTree = (FamilyTreeInterface<?>) object.readObject();

        object.close();

        return familyTree;
    }
}
