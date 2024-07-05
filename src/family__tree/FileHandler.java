package family__tree;

import java.io.*;

public class FileHandler implements Writer {
    @Override
    public void writeToFile(FamilyTree familyTree, String fileName) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree readFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (FamilyTree) in.readObject();
        }
    }
}
