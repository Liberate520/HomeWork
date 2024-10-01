package view.commands;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.Scanner;

public class AddParent extends Command {
    public AddParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить родителя";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID ребенка: ");
        long childId = Long.parseLong(scanner.nextLine());

        System.out.print("Введите имя родителя: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.print("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Введите дату смерти (YYYY-MM-DD) или оставьте пустым: ");
        String deathDateStr = scanner.nextLine();
        LocalDate deathDate = deathDateStr.isEmpty() ? null : LocalDate.parse(deathDateStr);

        Human parent = new Human(name, gender, birthDate, deathDate, null, null, null);


        System.out.println("Родитель добавлен.");
    }
}
