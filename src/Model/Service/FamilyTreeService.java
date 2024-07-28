package Service;

import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.*;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreeService {
    // private final FamilyTree<Human> familyTree;
    private Writer fileHandler;
    private FamilyTree<Human> familyTree;

    // public FamilyTreeService(FamilyTree<Human> familyTree, Writer fileHandler) {
    //     this.familyTree = familyTree;
    //     this.fileHandler = fileHandler;
    // }

    public FamilyTreeService(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
        this.fileHandler = new FamilyTreeFileHandler();
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        Human human = new Human(familyTree.getNextId(), name, birthDate, deathDate, gender, father, mother);
        familyTree.addElement(human);
    }

    public void sortByName() {
        familyTree.sortByName();
    }

        // public List<Human> getAllElements() {
    //     return familyTree.toList();
    // }

    public List<Human> getAllElements() {
        return familyTree.getElements();
    }

    public Human findByName(String name) {
        for (Human human : familyTree) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null; 
    }
    

    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void clearFamilyTree() {
        familyTree.clear();
    }

    public void save(String filename) {
        try {
        fileHandler.setPath(filename);
        fileHandler.save(familyTree);
        } catch(Exception e) {
            System.err.println("Ошибка при сохранени файла:" + e.getMessage());
        }
    }

    public void load(String filename) {
        fileHandler.setPath(filename);
        FamilyTree<Human> loadedTree = (FamilyTree<Human>) fileHandler.read();
        if (loadedTree != null) {
            this.familyTree = loadedTree;
            familyTree.clear();
            for (Human element : loadedTree.getAllElements()) {
                familyTree.addElement(element);
            }
        }
    }

    public Writer getFileHandler() {
        return fileHandler;
    }

}
