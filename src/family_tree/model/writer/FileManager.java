package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;
import family_tree.model.human.Human;

public class FileManager {
    private FileHandler fileHandler;

    public FileManager(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public boolean saveToFile(String fileName, FamilyTree<Human> familyTree){
        fileHandler.setFile(fileName);
        return fileHandler.save(familyTree);
    }

    public FamilyTree<Human> loadFromFile(String file){
        fileHandler.setFile(file);
        return (FamilyTree<Human>) fileHandler.read();
    }
}
