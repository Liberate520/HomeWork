package view;

import model.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
    }

    public ConsoleUI(Presenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        MainMenu menu = new MainMenu(this);
        boolean running = true;
        while (running) {
            System.out.println(menu.menu());
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 7) { // обновляем число опций
                running = false;
            }
            menu.execute(choice);
        }
    }

    public void displayHumanList() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения человека (гггг-мм-дд):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите пол человека (MALE/FEMALE):");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Укажите имя отца человека (или оставьте пустым):");
        String fatherName = scanner.nextLine();
        LocalDate fatherBirthDate = null;
        if (!fatherName.isEmpty()) {
            System.out.println("Укажите дату рождения отца (гггг-мм-дд):");
            fatherBirthDate = LocalDate.parse(scanner.nextLine());
        }

        System.out.println("Укажите имя матери человека (или оставьте пустым):");
        String motherName = scanner.nextLine();
        LocalDate motherBirthDate = null;
        if (!motherName.isEmpty()) {
            System.out.println("Укажите дату рождения матери (гггг-мм-дд):");
            motherBirthDate = LocalDate.parse(scanner.nextLine());
        }

        presenter.addHuman(name, birthDate, gender, fatherName, fatherBirthDate, motherName, motherBirthDate);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByAge();
    }

    public void findMemberByName() {
        System.out.println("Введите имя для поиска:");
        String name = scanner.nextLine();
        presenter.findMemberByName(name);
    }

    public void findMembersByBirthYear() {
        System.out.println("Введите год для поиска:");
        int year = Integer.parseInt(scanner.nextLine());
        presenter.findMembersByBirthYear(year);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
