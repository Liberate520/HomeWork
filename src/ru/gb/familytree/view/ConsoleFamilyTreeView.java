package ru.gb.familytree.view;

import ru.gb.familytree.presenter.FamilyTreePresenter;
import ru.gb.familytree.model.HumanInfo;

import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public ConsoleFamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showFamilyTree(List<HumanInfo> familyTree) {
        for (HumanInfo person : familyTree) {
            System.out.println(person);
        }
    }

    @Override
    public void showSuccess(String message) {
        System.out.println("Success: " + message);
    }

    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }

    @Override
    public void requestUserAction() {
        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Сортировка по имени");
            System.out.println("2. Сортировка по дате рождения");
            System.out.println("3. Найти конкретного человека");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline after nextInt()

            switch (choice) {
                case 1:
                    presenter.sortByName();
                    break;
                case 2:
                    presenter.sortByDob();
                    break;
                case 3:
                    System.out.println("Введите имя человека:");
                    String name = scanner.nextLine();
                    presenter.findPersonByName(name);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}