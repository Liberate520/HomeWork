package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.human.Gender;
import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI(Presenter presenter) {
        this.scanner = new Scanner(System.in);
        this.presenter = presenter;
        this.work = true;
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в наше семейное дерево!");
        while (work) {
            System.out.println(presenter.getMenu());
            int choice = Integer.parseInt(scanner.nextLine());
            presenter.executeCommand(choice);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void promptAddHuman() {
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг-мм-дд: ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите дату смерти в формате гггг-мм-дд или оставьте поле пустым: ");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);
        System.out.println("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.println("Введите национальность: ");
        String nationality = scanner.nextLine();
        presenter.addHuman(firstName, lastName, patronymic, birthDate, deathDate, gender, nationality, null, null, null,
                null, null);
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }
}