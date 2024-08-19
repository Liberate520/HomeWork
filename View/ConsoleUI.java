package homeWork.View;

import java.time.LocalDate;
import java.util.Scanner;

import homeWork.Model.Human.Gender;
import homeWork.Presenter.*;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final MainMenu menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До новых встреч");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void saveToFile() {
        presenter.saveToFile();
    }

    public void loadFromFile() {
        presenter.loadFromFile();
    }


    public void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Укажите дату рождения человека");
        String birthDayString = scanner.nextLine();
        LocalDate birthDay = LocalDate.parse(birthDayString);
        System.out.println("Укажите дату смерти человека");
        String deathDayString = scanner.nextLine();

        if (deathDayString == null || deathDayString.trim().isEmpty() || deathDayString.equalsIgnoreCase("null")) {
            LocalDate deathDay = null;
            presenter.addHuman(name,gender, birthDay, deathDay);
        }
        else {
            LocalDate deathDay = LocalDate.parse(deathDayString);
            presenter.addHuman(name,gender, birthDay, deathDay);
        }

    }

    public void removeHuman() {
        System.out.println("Введите индекс человека для его удаления");
        int index = scanner.nextInt();
        presenter.removeHuman(index);
    }

    private void hello(){
        System.out.println("Здравствуйте!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
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

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }


}
