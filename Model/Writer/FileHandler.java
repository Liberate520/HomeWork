package homeWork.Model.Writer;

import java.io.*;

import homeWork.Model.Tree.FamilyTree;

public class FileHandler implements Writer {
    @Override
    public void writeToFile(FamilyTree tree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree) ois.readObject();
        }
    }
}