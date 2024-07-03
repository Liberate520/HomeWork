package ru.gb.oop.family_tree.file;

import ru.gb.oop.family_tree.FamilyTree;

import java.io.*;

public class FileManajer implements Saver {
    String url = "out.ser";
    @Override
    public boolean save(Serializable obj) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(url))) {
            outputStream.writeObject(obj);
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public FamilyTree load() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(url))) {
            return (FamilyTree) inputStream.readObject();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
        return null;
    }
}
