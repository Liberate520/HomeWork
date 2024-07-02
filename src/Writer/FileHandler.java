package Writer;

import Tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer{
    private static final String dirName = "src\\Data\\";

    @Override
    public String create_name(String name){
        return dirName + name;
    }

    @Override
    public void writeFile(FamilyTree familyTree, String name) throws IOException {
        ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(create_name(name)));
        data.writeObject(familyTree);
        data.close();
    }

    @Override
    public FamilyTree readFile(String name) throws IOException, ClassNotFoundException {
        ObjectInputStream object = new ObjectInputStream(new FileInputStream(create_name(name)));
        return (FamilyTree) object.readObject();
    }
}
