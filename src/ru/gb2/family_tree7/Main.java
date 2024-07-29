package ru.gb2.family_tree7;

import ru.gb2.family_tree7.model.family_tree.FamilyTree;
import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.presenter.Presenter;
import ru.gb2.family_tree7.view.ConsoleUI;
import ru.gb2.family_tree7.view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        ConsoleUI view = new ConsoleUI() {
            @Override
            public void showFamilyMembers(boolean add) {

            }
        };
        Presenter presenter = new Presenter((View) view, familyTree);

        Human johnDoe = new Human(1, "John Doe", LocalDate.of(1980, 1, 1), Gender.MALE);
        Human janeDoe = new Human(2, "Jane Doe", LocalDate.of(1985, 5, 15), Gender.FEMALE);
        Human child = new Human(3, "Child Doe", LocalDate.of(2010, 3, 20), Gender.MALE);

        familyTree.add(johnDoe);
        familyTree.add(janeDoe);
        familyTree.add(child);

        johnDoe.addChild(child);
        janeDoe.addChild(child);
        child.addParent(johnDoe);
        child.addParent(janeDoe);

        presenter.displayFamilyTree();
    }
}
