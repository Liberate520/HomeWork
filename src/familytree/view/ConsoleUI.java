package familytree.view;

import familytree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение!";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void showFamilyTree() {
        presenter.showFamilyTree();
    }

    public void addFamilyMember() {
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол человека (Мужчина или Женщина): ");
        String gender = scanner.nextLine();
        System.out.println("Введите год рождения человека: ");
        String birthYearString = scanner.nextLine();
        int birthYear = Integer.parseInt(birthYearString);
        System.out.println("Введите месяц рождения человека: ");
        String birthMonthstring = scanner.nextLine();
        int birthMonth = Integer.parseInt(birthMonthstring);
        System.out.println("Введите день рождения человека: ");
        String birthDayString = scanner.nextLine();
        int birthDay = Integer.parseInt(birthDayString);
        if (!checkIfIsDead()) {
            System.out.println("Введите год смерти человека: ");
            String deathYearString = scanner.nextLine();
            int deathYear = Integer.parseInt(deathYearString);
            System.out.println("Введите месяц смерти человека: ");
            String deathMonthString = scanner.nextLine();
            int deathMonth = Integer.parseInt(deathMonthString);
            System.out.println("Введите день смерти человека: ");
            String deathDayString = scanner.nextLine();
            int deathDay = Integer.parseInt(deathDayString);
            presenter.addFamilyMember(name, gender, birthYear, birthMonth, birthDay, deathYear, deathMonth, deathDay);
        }

        presenter.addFamilyMember(name, gender, birthYear, birthMonth, birthDay, LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private void printMenu() {
        System.out.println(mainMenu.menu());
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkIfIsDead() {
        System.out.println("Человек умер? (да или нет)");
        String line = scanner.nextLine();
        return Objects.equals(line, "нет");
    }

}