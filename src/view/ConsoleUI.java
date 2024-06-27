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
    private Gender checkGenderInput(String input)
    {
        //Gender gender = null;
        switch (input) {
            case "М":
            case "м":
                return Gender.Male;
                //return true;
            case "Ж":
            case "ж":
                return Gender.Female;
                //return true;
            default:
                return null;
        }
    }
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
        String pattern = "yyyy MM dd";
        System.out.println("Укажите дату рождения " + pattern);
        //TODO реализовать проверку на валидность.
        LocalDate dateOfBirth = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        while(dateOfBirth==null) {
            dateOfBirth = checkDateValidInput(scanner.nextLine(), formatter);
            if(dateOfBirth==null){
                System.out.println("Неверно указана дата. Ввведите дату в формате " + pattern);
            }
        }
        //TODO Сделать возможным опционально ввести дату смерти
        System.out.println("Укажите пол (м\\ж)");
        Gender gender = null;
        while(gender==null) {
            gender = checkGenderInput(scanner.nextLine());
            if(gender==null) {
                System.out.println("Неверно указан пол. Укажите М или Ж");
            }
        }
        presenter.addHuman(name, lastName, dateOfBirth, gender);
    }

    private LocalDate checkDateValidInput(String input, DateTimeFormatter formatter) {
        try {
            return LocalDate.parse(input, formatter);
        }catch (Exception e){
            return null;
        }
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
