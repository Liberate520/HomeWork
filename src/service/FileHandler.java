package service;

import model.FamilyTree;
import java.io.*;

public class FileHandler implements FileSaver, FileLoader {

    @Override
    public void save(String fileName, FamilyTree<?> tree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(tree);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public FamilyTree<?> load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<?>) ois.readObject();
        }
    }
}
