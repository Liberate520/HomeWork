package view.commands;

import model.human.Gender;
import model.human.Human;
import view.ConsoleUI;

import java.time.LocalDate;
import java.util.Scanner;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "добавить или изменить данные члена семьи";

    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ID члена семьи для обновления или оставьте пустым");
        String idStr = scanner.nextLine();
        long id = idStr.isEmpty() ? -1 : Long.parseLong(idStr);

        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (Male/Female): ");
        String genderStr = scanner.nextLine();
        Gender gender = Gender.valueOf(genderStr);

        System.out.print("Введите дату рождения (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Введите дату смерти (YYYY-MM-DD) или оставьте пустым: ");
        String deathDateStr = scanner.nextLine();
        LocalDate deathDate = deathDateStr.isEmpty() ? null : LocalDate.parse(deathDateStr);


        Human human = new Human(name, gender, birthDate, deathDate, null, null, null);
        human.setId(id);


        consoleUI.getPresenter().getService().addOrUpdateHuman(human);

        System.out.println("Член семьи добавлен или обновлен.");
    }




}
