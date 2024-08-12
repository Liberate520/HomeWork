package ru.marat.geekbrains.presenter;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.userInterface.FamilyTreeView;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
        view.displayMessage("Член семьи добавлен: " + person.getName());
    }

    public void displayFamilyTree() {
        view.displayFamilyTree(familyTree);
    }

    public void sortFamilyTreeByName() {
        familyTree.sortByName((p1, p2) -> p1.getName().compareTo(p2.getName()));
        view.displayMessage("Семейное дерево отсортировано по имени.");
    }

    public void sortFamilyTreeByBirthDate() {
        familyTree.sortByBirthDate((p1, p2) -> p1.getBirthDate().compareTo(p2.getBirthDate()));
        view.displayMessage("Семейное дерево отсортировано по дате рождения.");
    }

    public void start() {
        view.start();
    }
}
