

package view.commands;

import model.human.Gender;
import model.human.Human;
import model.service.Service;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.Scanner;

public class AddChild implements Command {
    private final ConsoleUI consoleUI;
    private final Service service;

    public AddChild(ConsoleUI consoleUI, Service service) {
        this.consoleUI = consoleUI;
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = consoleUI.getScanner();

        System.out.println("Введите ID родителя:");
        long parentId = Long.parseLong(scanner.nextLine());

        Human parent = consoleUI.getParentById(parentId);
        if (parent == null) {
            System.out.println("Родитель с указанным ID не существует.");
            return;
        }

        System.out.println("Введите имя ребёнка:");
        String name = scanner.nextLine();

        System.out.println("Введите пол ребёнка (Male/Female):");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.println("Введите дату рождения ребёнка (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        boolean added = service.addChild(parentId, name, gender, birthDate);
        if (added) {
            System.out.println("Ребёнок успешно добавлен.");
        } else {
            System.out.println("Не удалось добавить ребёнка.");
        }
    }
}


