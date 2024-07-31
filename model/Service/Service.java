package model.Service;

import model.familyTree.FamilyTree;
import model.familyTree.Gender;
import model.familyTree.Human;
import model.Writer.FH;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        this.familyTree = new FamilyTree<>();
    }

    public void addMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        Human member = new Human(name, gender, birthDate, deathDate);
        familyTree.addMember(member);
    }

    public void addParents(String childName, String parent1Name, String parent2Name) {
        Human child = findMemberByName(childName);
        Human parent1 = findMemberByName(parent1Name);
        Human parent2 = findMemberByName(parent2Name);
        if (child != null && parent1 != null && parent2 != null) {
            child.addParent(parent1, parent2);
        }
    }

    public Human findMemberByName(String name) {
        for (Human member : familyTree.getFamily()) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public void sortByName() {
        familyTree.sortByName();
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public void saveFamilyTree(String fileName) {
        FH fileHandler = new FH();
        fileHandler.writeToFile(fileName, familyTree);
    }

    public void loadFamilyTree(String fileName) {
        FH fileHandler = new FH();
        this.familyTree = fileHandler.readFromFile(fileName);
    }
}
