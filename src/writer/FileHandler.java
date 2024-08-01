package writer;

import familytree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public void writeToFile(FamilyTree tree, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
