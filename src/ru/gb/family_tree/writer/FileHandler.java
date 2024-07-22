package ru.gb.family_tree.writer;
import ru.gb.family_tree.family_tree.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree){
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            this.familyTree = (FamilyTree) ois.readObject();
        }
    }

    public FamilyTree getFamilyTree(){
        return familyTree;
    }
}
