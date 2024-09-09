package view.commands;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.Scanner;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить ребенка";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID родителя: ");
        long parentId = Long.parseLong(scanner.nextLine());

        System.out.print("Введите имя ребенка: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.print("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Введите дату смерти (YYYY-MM-DD) или оставьте пустым: ");
        String deathDateStr = scanner.nextLine();
        LocalDate deathDate = deathDateStr.isEmpty() ? null : LocalDate.parse(deathDateStr);

        Human child = new Human(name, gender, birthDate, deathDate, null, null, null);


        System.out.println("Ребенок добавлен.");
    }
}

