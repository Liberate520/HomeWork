package familytree.service;

import familytree.model.FamilyTree;
import familytree.model.TreeMember;

import java.io.*;

public class FileHandler<T extends TreeMember> implements Writer<T> {
    @Override
    public void save(FamilyTree<T> familyTree, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> load(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}