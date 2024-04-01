package Writable;

import FamilyTree.FamilyTree;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FamilyTreeWritable {
    public static void writeFamilyTree(FamilyTree familyTree, String fileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(familyTree);
        }
    }

    public static FamilyTree readFamilyTree(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (FamilyTree) ois.readObject();
        }
    }
}
