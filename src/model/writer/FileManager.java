package model.writer;

import model.family_tree.FamilyTree;
import model.human.Human;

public class FileManager {
    private FileHandler fileHandler;

    public FileManager(FileHandler fileHandler){
        this.fileHandler = fileHandler;
    }

    public boolean saveToFile(String filename, FamilyTree<Human> familyTree) {
        fileHandler.setPath(filename);
        return fileHandler.save(familyTree);
    }

    public FamilyTree<Human> loadFromFile(String filePath) {
        fileHandler.setPath(filePath);
        return (FamilyTree<Human>) fileHandler.read();

    }
}
