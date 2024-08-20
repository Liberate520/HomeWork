package model.Service;

import model.familyTree.FamilyTree;
import model.familyTree.Gender;
import model.familyTree.Human;
import model.Writer.FileHandler;
import java.time.LocalDate;
import java.util.Comparator;

public class Service {
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler; 

    public Service(FileHandler fileHandler) {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = fileHandler;
    }

    public void addMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human member = new Human(name, gender, birthDate, deathDate);
        familyTree.addMember(member);
    }

    public void sort(Comparator<Human> comparator) {
        familyTree.sort(comparator);
    }

    public void sortByName() {
        sort(Comparator.comparing(Human::getName));
    }

    public void sortByAge() {
        sort(Comparator.comparing(Human::getBirthDate));
    }

    public void saveFamilyTree(String fileName) {
        fileHandler.writeToFile(fileName, familyTree);
    }

    public void loadFamilyTree(String fileName) {
        this.familyTree = fileHandler.readFromFile(fileName);
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}