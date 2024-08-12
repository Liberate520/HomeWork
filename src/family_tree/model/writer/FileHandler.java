package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public boolean save(Serializable serializable) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/family_tree/model/writer/familyTree.txt"));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object load() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/family_tree/model/writer/familyTree.txt"));
            FamilyTree tree = (FamilyTree)objectInputStream.readObject();
            objectInputStream.close();
            return tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
