package View;

import java.time.LocalDate;
import java.util.Scanner;
import View.Commands.*;
import model.Model;
import model.familyTree.Gender;

public class View {
    private Scanner scanner;
    private Model model;
    private Menu menu;

    public View(Model model, Menu menu) {
        this.scanner = new Scanner(System.in);
        this.model = model;
        this.menu = menu;
        initializeMenu();
    }

    private void initializeMenu() {
        menu.addCommand(new AddMember(model, this));
        menu.addCommand(new SortByName(model, this));
        menu.addCommand(new SortByAge(model, this));
        menu.addCommand(new ShowFamilyTree(model, this));
        menu.addCommand(new SaveFamilyTree(model, this));
        menu.addCommand(new LoadFamilyTree(model, this));
    }

    public String getNameInput() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    public Gender getGenderInput() {
        while (true) {
            System.out.print("Введите пол (Male or Female): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Male")) {
                return Gender.Мужской;
            } else if (input.equalsIgnoreCase("Female")) {
                return Gender.Женский;
            } else {
                System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
            }
        }
    }

    public LocalDate getBirthDateInput() {
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        return LocalDate.parse(scanner.nextLine());
    }

    public LocalDate getDeathDateInput() {
        System.out.print("Введите дату смерти (ГГГГ-ММ-ДД) или оставьте пустым, если жив: ");
        String input = scanner.nextLine();
        return input.isEmpty() ? null : LocalDate.parse(input);
    }

    public String getFileNameInput() {
        System.out.print("Введите название файла: ");
        return scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showFamilyTree(String familyTree) {
        System.out.println("Семейное дерево:\n" + familyTree);
    }

    public int getUserChoice() {
        System.out.print("Выберите действие: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
