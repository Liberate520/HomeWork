package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean active;
    private MainMenu mainMenu;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        active = true;
        mainMenu = new MainMenu(this);
    }
    @Override
    public void start() {
        System.out.println("Приветствую %username%");
        while (active) {
            System.out.println(mainMenu.menu());
            String choiceString  = scanner.nextLine();
            int choice = 0;
            try {
                choice = Integer.parseInt(choiceString);
                mainMenu.execute(choice);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void finish() {
        active = false;
        System.out.println("До свидания!!!!");
    }


    public void addHuman() {
        System.out.println("Укажите имя");
        String name  = scanner.nextLine();
        System.out.println("Укажите фамилию");
        String lastName  = scanner.nextLine();
        System.out.println("Укажите дату рождения yyyy-mm-dd");
        //TODO реализовать проверку на валидность.
        String pattern = "yyyy-MM-dd";
        String input = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        LocalDate dateOfBirth = LocalDate.parse(input, formatter);
        //TODO Сделать возможным опционально ввести дату смерти

        System.out.println("Укажите пол (м\\ж)");
        input = scanner.nextLine();
        boolean invalidInput = true;
        Gender gender = null;
        while(invalidInput) {
            switch (input) {
                case "М":
                case "м":
                    gender = Gender.Male;
                    invalidInput = false;
                    break;
                case "Ж":
                case "ж":
                    gender = Gender.Female;
                    invalidInput = false;
                    break;
                default:
                    System.out.println("Неверно указан пол. Укажите М или Ж");
            }
        }
        presenter.addHuman(name, lastName, dateOfBirth, gender);
    }
    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }
    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByLastName() {
        presenter.sortByLastName();
    }
    public void sortByAge() {
        presenter.sortByAge();
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }
}
