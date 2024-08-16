package view.commands;

import java.time.LocalDate;

import model.human.Gender;
import presenter.Presenter;
import java.util.Scanner;

// Применяем SRP: Класс AddHuman отвечает за добавление человека.
public class AddHuman extends Command {

    public AddHuman(Presenter presenter) {
        super("Добавить человека", presenter);
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВедите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг-мм-дд: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите дату рождения в формате гггг-мм-дд или оставьте поле пустым: ");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);
        System.out.println("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Введите национальность: ");
        String nationality = scanner.nextLine();
        presenter.addHuman(firstName, lastName, patronymic, birthDate, deathDate, gender, nationality, null, null, null,
                null, null);
    }
}
