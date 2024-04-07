package src.backup;

import src.familyTree.FamilyTree;

import java.io.*;

public class FileHandler implements Writable {

    public boolean save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            objectOutputStream.writeObject(serializable);
            System.out.println("File " + filePath + " has been created");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public FamilyTree read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            System.out.println("File " + filePath + " has been loaded");
            return (FamilyTree) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}