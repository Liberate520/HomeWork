package project.View;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import project.Members.Gender;
import project.Members.Human;
import project.Members.TreeMember;
import project.Presenter.FamilyTreePresenter;
import project.Presenter.FamilyTreePresenterImpl;

public class FamilyTreeConsoleView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private Scanner scanner;

    public FamilyTreeConsoleView() {
        this.presenter = new FamilyTreePresenterImpl(this);
        this.scanner = new Scanner(System.in);
    }

    public FamilyTreePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void displayMemberDescriptions(List<String> descriptions) {
        for (String description : descriptions) {
            System.out.println(description);
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayChildren(List<TreeMember> children) {
        if (children.isEmpty()) {
            System.out.println("Дети не найдены.");
        } else {
            for (TreeMember child : children) {
                System.out.println(child);
            }
        }
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            handleUserInput(choice);
        }
    }

    private void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавть в древо");
        System.out.println("2. Сохранить семейное дерево");
        System.out.println("3. Загрузить семейное древо");
        System.out.println("4. Отображение детей участника древа");
        System.out.println("5. Сортировать по имени");
        System.out.println("6. Сортировать по дате рождения");
        System.out.println("7. Выход");
        System.out.print("Введите цифру, соответствующую вашему выбору: ");
    }

    private void handleUserInput(int choice) {
        switch (choice) {
            case 1:
                addMember();
                break;
            case 2:
                saveFamilyTree();
                break;
            case 3:
                loadFamilyTree();
                break;
            case 4:
                displayChildrenOf();
                break;
            case 5:
                presenter.sortByName();
                break;
            case 6:
                presenter.sortByBirthDate();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
        }
    }

    private void addMember() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите пол (мужской/женский): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addMember(new Human(name, birthDate, gender));
    }

    private void saveFamilyTree() {
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        presenter.saveFamilyTree(filename);
    }

    private void loadFamilyTree() {
        System.out.print("Введите имя файла: ");
        String filename = scanner.nextLine();
        presenter.loadFamilyTree(filename);
    }

    private void displayChildrenOf() {
        System.out.print("Введите имя участника древа: ");
        String name = scanner.nextLine();
        presenter.displayChildrenOf(name);
    }
}
