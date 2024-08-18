package View;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Model.FamilyTree;
import Model.Human;
import Presenter.FamilyTreePresenter;

public class FamilyTreeConsoleView<T extends Human> implements FamilyTreeView<T> {
    private Scanner scanner;
    private FamilyTreePresenter<T> presenter;

    public FamilyTreeConsoleView() {
        scanner = new Scanner(System.in);
    }

    public void setPresenter(FamilyTreePresenter<T> presenter) {
        this.presenter = presenter;
    }

    @Override
    public void displayFamilyTree(List<T> familyMembers) {
        System.out.println("Семейное древо:");
        for (T member : familyMembers) {
            System.out.println(member);
        }
        if (familyMembers.isEmpty()) {
            System.out.println("Семейное древо пусто.");
        }
    }

    @Override
    public String getNameForChildren() {
        System.out.println("Введите имя для отображения детей:");
        return scanner.nextLine();
    }

    @Override
    public String getNameForParents() {
        System.out.println("Введите имя для отображения родителей:");
        return scanner.nextLine();
    }

    @Override
    public void displayChildren(String name, List<T> children) {
        if (children != null && !children.isEmpty()) {
            System.out.println("Дети " + name + ":");
            for (T child : children) {
                System.out.println(child);
            }
        } else {
            System.out.println("У данного человека нет детей или человек с именем " + name + " не найден.");
        }
    }

    @Override
    public void displayParents(String name, List<T> parents) {
        if (parents != null && !parents.isEmpty()) {
            System.out.println("Родители " + name + ":");
            for (T parent : parents) {
                System.out.println(parent + ", возраст: " + parent.getAgeAt(LocalDate.now()));
            }
        } else {
            System.out.println("Человек с именем " + name + " не найден.");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать семейное древо");
            System.out.println("2. Просмотреть список детей");
            System.out.println("3. Посмотреть список родителей");
            System.out.println("4. Найти детей по имени родителя");
            System.out.println("5. Найти родителей по имени ребенка");
            System.out.println("6. Выйти");

            System.out.print("Выберите пункт меню (1-6): ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    presenter.displayFamilyTree();
                    break;
                case 2:
                    presenter.childrenRequest();
                    break;
                case 3:
                    presenter.parentsRequest();
                    break;
                case 4:
                    presenter.childrenRequest();
                    break;
                case 5:
                    presenter.parentsRequest();
                    break;
                case 6:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }
}
