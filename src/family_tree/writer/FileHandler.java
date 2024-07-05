package family_tree.writer;

import family_tree.family_tree1.FamilyTree;

import java.io.*;

public class FileHandler implements Writer {

    @Override
    public void save(String filePath, FamilyTree familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(filePath)))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree load(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(filePath)))) {
            return (FamilyTree) ois.readObject();
        }
    }
}
