package ru.marat.geekbrains;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.presenter.FamilyTreePresenter;
import ru.marat.geekbrains.userInterface.ConsoleFamilyTreeView;
import ru.marat.geekbrains.userInterface.FamilyTreeView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", LocalDate.of(1983, 5, 10), "Male");
        Person jane = new Person("Jane", LocalDate.of(1985, 3, 15), "Female");
        Person child1 = new Person("Child1", LocalDate.of(2005, 6, 20), "Female");
        Person child2 = new Person("Child2", LocalDate.of(2008, 9, 5), "Male");

        child1.setMother(jane);
        child1.setFather(john);
        child2.setMother(jane);
        child2.setFather(john);

        FamilyTree<Person> familyTree = new FamilyTree<>();
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        FamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, view);
        ((ConsoleFamilyTreeView) view).setPresenter(presenter);

        presenter.start();
    }
}
