package ru.marat.geekbrains.presenter;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.userInterface.FamilyTreeView;

import java.util.Comparator;

public class FamilyTreePresenter {
    private FamilyTree<Person> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree<Person> familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.displayMessage("Введите команду (add, list, sort_name, sort_date, exit):");
            String command = view.getUserInput();

            switch (command) {
                case "add":
                    // Логика добавления нового члена семьи
                    break;
                case "list":
                    view.displayFamilyTree(familyTree.toString());
                    break;
                case "sort_name":
                    familyTree.sortByName(Comparator.comparing(Person::getName));
                    view.displayMessage("Отсортировано по имени.");
                    break;
                case "sort_date":
                    familyTree.sortByBirthDate(Comparator.comparing(Person::getBirthDate));
                    view.displayMessage("Отсортировано по дате рождения.");
                    break;
                case "exit":
                    view.displayMessage("Выход...");
                    return;
                default:
                    view.displayMessage("Неизвестная команда.");
                    break;
            }
        }
    }
}
