package Writers;

import java.io.*;

import FamilyTree.FamilyTree;

public class FileHandler implements Writer{
    ObjectOutputStream objectOutputStream;
    ObjectInputStream objectInputStream;


    public FamilyTree read(String filename) throws IOException, ClassNotFoundException {
        File familyFile = new File(filename);
        if (!familyFile.exists()) {
            FamilyTree familyTree = new FamilyTree();
            write(filename, familyTree);
            return familyTree;
        }      

        objectInputStream = new ObjectInputStream(new FileInputStream(filename));
        FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
        objectInputStream.close();
        return familyTree;
    }
    public void write(String filename, FamilyTree familyTree) throws IOException {
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename));
        objectOutputStream.writeObject(familyTree);
        objectOutputStream.close();
    }
}
