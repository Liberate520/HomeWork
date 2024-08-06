package model.writer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.family_tree.FamilyTree;
import model.human.Human;

public class FileHandler implements Writer {

    public void write(FamilyTree<Human> obj, String fileName) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(fileName, false));
            oos.writeObject(obj);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("rawtypes")
    public FamilyTree read(String fileName) throws ClassNotFoundException {
        ObjectInputStream ois;
        FamilyTree obj = null;
        ;
        try {
            ois = new ObjectInputStream(new FileInputStream(fileName));
            obj = (FamilyTree) ois.readObject();
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return obj;
    }
}