package model.service;

import model.family_tree.FamilyTree;
import model.human.Human;
import model.writer.FileHandler;

public class FileOperationServise {
    FileHandler fileHandler;

    public FileOperationServise() {
        fileHandler = new FileHandler();
    }

    public void saveFamilyTree(FamilyTree<Human> familyTree) {
        fileHandler.write(familyTree, "FamilyTree.bin");
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public FamilyTree<Human> loadFamilyTree() {
        try {
            return (FamilyTree) fileHandler.read("FamilyTree.bin");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}