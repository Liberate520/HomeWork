package model.Service;

import model.familyTree.FamilyTree;
import model.familyTree.FamilyTreeMember;
import model.familyTree.Gender;
import model.familyTree.Human;
import model.Writer.FileHandler;
import java.time.LocalDate;
import java.util.Comparator;

public class Service<T extends FamilyTreeMember<T>> {
    private FamilyTree<T> familyTree;
    private FileHandler fileHandler;
    private Gender gender;

    public Service(FileHandler fileHandler) {
        this.familyTree = new FamilyTree<>();
        this.fileHandler = fileHandler;
    }

    public void addMember(String id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        @SuppressWarnings("unchecked")
        T member = (T) new Human(id, name, gender, birthDate, deathDate);
        familyTree.addMember(member);
    }

    public void createFamilyLink(String childId, String parentId) {
        familyTree.createFamilyLink(childId, parentId);
    }

    public void sort(Comparator<T> comparator) {
        familyTree.sort(comparator);
    }

    public void sortByName() {
        sort(Comparator.comparing(FamilyTreeMember::getName));
    }

    public void sortByAge() {
        sort(Comparator.comparing(FamilyTreeMember::getBirthDate));
    }

    public void saveFamilyTree(String fileName) {
        fileHandler.writeToFile(fileName, familyTree);
    }

    public void loadFamilyTree(String fileName) {
        this.familyTree = fileHandler.readFromFile(fileName);
    }

    public FamilyTree<T> getFamilyTree() {
        return familyTree;
    }

    public Gender getGender() {
        return gender;
    }
}
