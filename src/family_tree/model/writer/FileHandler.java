package family_tree.model.writer;

import family_tree.model.family_tree1.FamilyTree;
import family_tree.model.human.Human;
import java.io.*;

public class FileHandler implements Writer {

    private static final String FILE_PATH = "src/family_tree/model/writer/familyTree.ser";

    @Override
    public void save(String FILE_PATH, FamilyTree<?> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FileHandler.FILE_PATH))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<Human> load(String FILE_PATH) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FileHandler.FILE_PATH))) {
            return (FamilyTree<Human>) ois.readObject();
        }
    }
}
