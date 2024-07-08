package family_tree.writer;

import family_tree.family_tree1.FamilyTree;
import family_tree.human.Human;

import java.io.*;

public class FileHandler implements Writer {
    private static final String FILE_PATH = "familyTree.ser";

    @Override
    public void save(FamilyTree<?> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<Human> load() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (FamilyTree<Human>) ois.readObject();
        }
    }

    public static String getFilePath() {
        return FILE_PATH;
    }
}
