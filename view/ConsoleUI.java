package view;

import java.time.LocalDate;
import java.util.Scanner;

import presenter.Presenter;
import model.human.Gender;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в наше семейное дерево!");
        while (work) {
            System.out.println(menu.menu());
            int choice = Integer.parseInt(scanner.nextLine());
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("Всего доброго!");
        scanner.close();
        work = false;
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByLastName() {
        presenter.sortByLastName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void addHuman() {
        System.out.println("ВВедите имя: ");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите отчество: ");
        String patronymic = scanner.nextLine();
        System.out.println("Введите дату рождения в формате гггг-мм-дд): ");
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

    public void addPlace() {
        System.out.println("Введите номер дома: ");
        int homeNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите улицу: ");
        String street = scanner.nextLine();
        System.out.println("Введите название субьекта: ");
        String region = scanner.nextLine();
        System.out.println("Введите страну: ");
        String country = scanner.nextLine();
        System.out.println("Введите почтовый индекс: ");
        int postalCode = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите название населенного пункта: ");
        String locality = scanner.nextLine();
        presenter.addPlace(homeNumber, street, region, country, postalCode, locality);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    private void error() {
        System.out.println("Неправильный выбор!");
    }
}