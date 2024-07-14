package family_tree.model.service;

import family_tree.model.family_tree1.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.writer.FileHandler;
import java.io.IOException;

public class FileFamilyTreeService {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;
    private final String FILE_PATH = "src/family_tree/model/writer/familyTree.ser";

    public FileFamilyTreeService() {
        this.familyTree = new FamilyTree<>();
        fileHandler = new FileHandler();
    }

    public void saveFamilyTree() {
        try {
            fileHandler.save(FILE_PATH, familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FamilyTree<Human> loadFamilyTree() {
        try {
            FamilyTree<Human> loadedTree = fileHandler.load(FILE_PATH);
            if (loadedTree != null) {
                familyTree = loadedTree;

                // Код для определения максимального ID
                int maxId = 0;
                for (Human human : familyTree.getHumans()) {
                    if (human.getId() > maxId) {
                        maxId = human.getId();
                    }
                }
                Human.resetIdCounter(maxId);

                return loadedTree;
            }
            return new FamilyTree<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new FamilyTree<>();
        }
    }
}
