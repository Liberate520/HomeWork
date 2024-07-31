package model.Writer;

import java.io.*;
import model.familyTree.FamilyTree;
import model.familyTree.Human;

public class FH implements Writer {

    @Override
    public void writeToFile(String fileName, FamilyTree<Human> familyTree) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public FamilyTree<Human> readFromFile(String fileName) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<Human>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
