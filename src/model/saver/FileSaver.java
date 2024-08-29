package model.saver;

import model.human.Human;
import model.tree.FamilyTree;

import java.io.*;

public class FileSaver implements Saver{
    private String filePath;

    @Override
    public boolean save(Serializable serializable) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public FamilyTree<Human> restore() {
        Object tree = null;
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            tree = objectInputStream.readObject();
            objectInputStream.close();
            return (FamilyTree<Human>) tree;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;

    }
}
