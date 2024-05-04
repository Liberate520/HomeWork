package view;

import model.Human.Gender;
import model.Human.Human;
import presenter.Presenter;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (work) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }

    }

    private static void error() {
        System.out.println("Введено_неправильное_значение");
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void loadFamilyTree() { presenter.loadFamilyTree(); }

    public void saveFamilyTree() { presenter.saveFamilyTree(); }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя человека:");
        String name = scanner.nextLine();
        System.out.println("Укажите фамилию человека:");
        String secondName = scanner.nextLine();
        System.out.println("Выберите пол человека: Male или Female:");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения человека (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Известна ли дата смерти, если да - укажите (YYYY-MM-DD) :");
        LocalDate deathDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите имя мамы:");
        String motherName = scanner.nextLine();
        System.out.println("Укажите имя папы:");
        String fatherName = scanner.nextLine();


        presenter.addHuman(name, secondName, gender, birthDate, deathDate, motherName, fatherName);

    }



    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
