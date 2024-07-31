package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
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

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand<=menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private boolean checkTextForInt(String line) {
        if (line.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол: MALE - 1/FEMALE - 2");
        Gender gender = findGender(scanner.nextLine());
        System.out.println("Укажите возраст");
        String ageString = scanner.nextLine();
        int age = Integer.parseInt(ageString);
        LocalDate today = LocalDate.now();
        LocalDate birthday = today.minusYears(age);

        presenter.addHuman(name, gender, birthday);
    }

    private Gender findGender(String gender){
        Gender gender1 = Gender.MALE;
        Gender gender2 = Gender.FEMALE;
        if (gender.equals("1")){
            return gender1;
        } else if (gender.equals("2")) {
          return gender2;
        } else {
            System.out.println(INPUT_ERROR);
        }
        return gender1;
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    public void finish(){
        System.out.println("Приятно было пообщатся!");
        work = false;
    }

    public void setWedding(){
        presenter.setWedding();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void getPeopleInfo(){
        presenter.getPeopleInfo();
    }

}
