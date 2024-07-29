package ru.gb2.family_tree7;

import ru.gb2.family_tree7.model.family_tree.FamilyTree;
import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.presenter.FamilyTreePresenter;
import ru.gb2.family_tree7.view.ConsoleFamilyTreeView;
import ru.gb2.family_tree7.view.FamilyTreeView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView() {
            @Override
            public void showFamilyMembers(boolean add) {

            }
        };
        FamilyTreePresenter presenter = new FamilyTreePresenter((FamilyTreeView) view, familyTree);

        Human ivanIvanov = new Human(1, "Ivan Ivanov", LocalDate.of(1980, 1, 1), Gender.MALE, "Отец");
        Human ianaIvanova = new Human(2, "Iana Ivanova", LocalDate.of(1985, 5, 15), Gender.FEMALE, "Мать");
        Human child = new Human(3, "Igor Ivanov", LocalDate.of(2010, 3, 20), Gender.MALE, " Ребенок");

        familyTree.add(ivanIvanov);
        familyTree.add(ianaIvanova);
        familyTree.add(child);

        ivanIvanov.addChild(child);
        ianaIvanova.addChild(child);
        child.addParent(ivanIvanov);
        child.addParent(ianaIvanova);

        presenter.displayFamilyTree();
    }
}
