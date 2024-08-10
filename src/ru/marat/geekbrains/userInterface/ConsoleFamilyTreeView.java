package ru.marat.geekbrains.userInterface;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.presenter.FamilyTreePresenter;

import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду (add, list, sort_name, sort_date, exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    // Логика добавления нового члена семьи
                    break;
                case "list":
                    presenter.displayFamilyTree();
                    break;
                case "sort_name":
                    presenter.sortFamilyTreeByName();
                    break;
                case "sort_date":
                    presenter.sortFamilyTreeByBirthDate();
                    break;
                case "exit":
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }

    @Override
    public void displayFamilyTree(FamilyTree<Person> familyTree) {
        System.out.println(familyTree);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }
}
