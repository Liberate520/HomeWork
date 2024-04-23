package homeWork;

import java.time.LocalDate;

import homeWork.model.FamilyTree;
import homeWork.model.Human;
import homeWork.presenter.FamilyTreePresenter;
import homeWork.utils.FileHandler;
import homeWork.view.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        String filePath = "tree.txt";

        FamilyTree<Human> tree = testTree();
        System.out.println(tree);

        FamilyTreeView view = new FamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(tree, view);
        presenter.start();

        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree, filePath);
    }

    static FamilyTree<Human> testTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha);

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25), vasya, masha);
        tree.add(christina);
        tree.add(semyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);
        tree.add(grandMother);

        return tree;
    }
}

