package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.family_tree.FamilyTree;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.Gender;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> familyTree;
    private long nextId;

    public Service() {
        familyTree = new FamilyTree<>();
        nextId = 1;
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        Human father = fatherName != null && !fatherName.isEmpty() ?
                familyTree.getMember(fatherName) : null;
        if (father == null && fatherName != null && !fatherName.isEmpty()) {
            father = new Human(nextId++, fatherName, fatherBirthDate, Gender.Male, null, null);
            familyTree.addElement(father);
        }

        Human mother = motherName != null && !motherName.isEmpty() ?
                familyTree.getMember(motherName) : null;
        if (mother == null && motherName != null && !motherName.isEmpty()) {
            mother = new Human(nextId++, motherName, motherBirthDate, Gender.Female, null, null);
            familyTree.addElement(mother);
        }

        Human human = new Human(nextId++, name, dateOfBirth, gender, fatherName, motherName);
        familyTree.addElement(human);

        if (father != null) {
            father.addChild(human);
        }

        if (mother != null) {
            mother.addChild(human);
        }
    }

    public String getHumanInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : familyTree) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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

    public void setFamilyTree(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }
}
