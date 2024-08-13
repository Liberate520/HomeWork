// FamilyTreePresenter.java
package ru.gb.family_tree.presenter;

import java.time.LocalDate;
import java.util.Comparator;
import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Gender;
import ru.gb.family_tree.Human;
import ru.gb.family_tree.Nationality;
import ru.gb.family_tree.view.View;

public class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private View view;

    public FamilyTreePresenter(View view) {
        this.view = view;
        this.familyTree = new FamilyTree<>(Human::getChildren);
    }

    public void initializeFamilyTree() {
        Human father = new Human(LocalDate.of(1975, 5, 20), "John", "Michael", "Doe", Gender.Male,
                Nationality.AU, "Sydney", null, null, null);
        Human mother = new Human(LocalDate.of(1978, 8, 15), "Jane", "Elizabeth", "Smith", Gender.Female,
                Nationality.AU, "Melbourne", null, null, null);
        Human child1 = new Human(LocalDate.of(2000, 3, 30), "Alice", "Marie", "Doe", Gender.Female,
                Nationality.AU, "Sydney", mother, father, null);
        Human child2 = new Human(LocalDate.of(2002, 7, 10), "Bob", "John", "Doe", Gender.Male,
                Nationality.AU, "Sydney", mother, father, null);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);
    }

    public String getFamilyTree() {
        return familyTree.toString();
    }

    public void sortByName() {
        familyTree.sortByCriterion(Comparator.comparing(Human::getFirstName));
    }

    public void sortByBirthDate() {
        familyTree.sortByCriterion(Comparator.comparing(Human::getBirthDate));
    }

    public Human findByFullName(String fullName) {
        return familyTree.findByCriterion(h -> h.getFullName().equalsIgnoreCase(fullName));
    }

    public String getChildren(Human parent) {
        FamilyTree<Human> childrenTree = familyTree.getChildren(parent);
        return childrenTree.toString();
    }
}
