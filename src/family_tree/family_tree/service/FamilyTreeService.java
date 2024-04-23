package family_tree.family_tree.service;

import family_tree.family_tree.model.FamilyTreeModel;
import family_tree.human.Human;
import family_tree.writer.FileHandler;

import java.util.List;

public class FamilyTreeService {
    private FamilyTreeModel model;
    private FileHandler fileHandler;

    public FamilyTreeService(FamilyTreeModel model, FileHandler fileHandler) {
        this.model = model;
        this.fileHandler = fileHandler;
    }

    public void addFamilyMember(Human member) {
        model.addFamilyMember(member);
    }

    public List<Human> getFamilyMembers() {
        return model.getFamilyMembers();
    }

    public void saveToFile(String fileName) {
        List<Human> familyMembers = model.getFamilyMembers();
        fileHandler.saveToFile(fileName, familyMembers);
    }

    public List<Human> loadFromFile(String fileName) {
        return fileHandler.loadFromFile(fileName);
    }
}
