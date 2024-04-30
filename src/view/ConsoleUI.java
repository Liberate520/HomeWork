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
        System.out.println("Выберите пол человека:");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения человека:");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        presenter.addHuman(name, secondName, gender, birthDate);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
