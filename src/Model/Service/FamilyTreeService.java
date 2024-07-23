package Service;

import FamilyTree.FamilyTree;
import Human.Gender;
import Human.Human;
import Writer.*;

import java.time.LocalDate;

public class FamilyTreeService {
    private final FamilyTree<Human> familyTree;

    public FamilyTreeService(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        Human human = new Human(familyTree.getNextId(), name, birthDate, deathDate, gender, father, mother);
        familyTree.addElement(human);
    }

    public void sortByName() {
        familyTree.sortByName();
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

    public Human findByName(String name) {
        return familyTree.findByName(name);
    }

    public void save(Writer fileHandler, String filename) {
        fileHandler.setPath(filename);
        fileHandler.save(familyTree);
    }

    public void load(Writer fileHandler) {
        FamilyTree<?> loadedTree = fileHandler.read();
        if (loadedTree != null) {
            this.familyTree.clear();
            for (Object element : loadedTree.getAllElements()) {
                if (element instanceof Human) {
                    familyTree.addElement((Human) element);
                }
            }
        }
    }
}
