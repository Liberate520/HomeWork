package my_fam_tree.service;

import my_fam_tree.model.FamTreeOper;
import my_fam_tree.model.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public void saveToFile(String fileName, FamTreeOper<?> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<?> loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            return (FamilyTree<?>) ois.readObject();
        }
    }
}
