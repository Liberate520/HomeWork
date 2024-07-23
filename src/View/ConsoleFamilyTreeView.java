package View;

import Human.Human;
import Presenter.FamilyTreePresenter;
import View.Сommand.*;

import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    private FamilyTreePresenter presenter;
    private final Scanner scanner;

    public ConsoleFamilyTreeView(FamilyTreePresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showFamilyTree(List<Human> family) {
        for (Human human : family) {
            System.out.println(human);
        }
    }

    // @Override
    // public void showFamilyTree(List<Human> family) {
    //     for (Human member : family) {
    //         System.out.println("Name: " + member.getName());
    //         showChildren(member, "  ");
    //     }
    // }

    // private void showChildren(Human parent, String indent) {
    //     for (Human child : parent.getChildren()) {
    //         System.out.println(indent + "Child: " + child.getName());
    //         showChildren(child, indent + "  ");
    //     }
    // }




    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }

    @Override
    public void setPresenter(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showMenu() {
        boolean work = true;

        while (work) {
            System.out.println("1. Добавить члена семьи");
            System.out.println("2. Вывести дерево на печать");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Отсортировать по дате рождения");
            System.out.println("6. Сохранить в файл");
            System.out.println("7. Выгрузить из файла");
            System.out.println("8. Выход");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    new AddHumanCommand(presenter, scanner).execute();
                    break;
                case "2":
                    new PrintTreeCommand(presenter).execute();
                    break;
                case "3":
                    new SortByNameCommand(presenter).execute();
                    break;
                case "4":
                    new SortByAgeCommand(presenter).execute();
                    break;
                case "5":
                    new SortByBirthDateCommand(presenter).execute();
                    break;
                case "6":
                    new SaveCommand(presenter, scanner).execute();
                    break;
                case "7":
                    new LoadCommand(presenter, scanner).execute();
                    break;
                case "8":
                    work = false;
                    scanner.close();
                    break;
                default:
                    showError("Неизвестная команда: " + input);
            }
        }
    }
}
