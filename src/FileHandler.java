import PersonsTree.FamilyTree;

import java.io.*;

public abstract class FileHandler implements Writable, Serializable {
    public void save(Object familyTree) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.txt"));
            objectOutputStream.writeObject(familyTree);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.txt"));
            FamilyTree familyTree = (FamilyTree) objectInputStream.readObject();
            return familyTree;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
