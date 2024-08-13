package lv.homeWork.view;

import lv.homeWork.model.Gender;
import lv.homeWork.presenter.Presenter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private boolean menuGo;
    private MainMenu mainMenu;
    private static final String INPUT_ERROR = "Something went wrong, please try again";

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menuGo = true;
        mainMenu = new MainMenu(this);
    }


    @Override
    public void start() {
        begin();
        while (menuGo){
            printMainMenu();
            act();
        }

    }

    @Override
    public void getAnswer(String answer) {
        System.out.println(answer);

    }

    public void printMainMenu(){
        System.out.println(mainMenu.menu());
    }

    public void begin(){
        System.out.println("Hello User!");
    }


    public void act(){
        String line = scanner.nextLine();
        if (checkForInt(line)){
            int numOfOption = Integer.parseInt(line);
            if (checkCommand(numOfOption)){
                mainMenu.act(numOfOption);
            }
        }
    }

    private boolean checkCommand(int numOfOption){
        if(numOfOption <= mainMenu.getSize()){
            return true;
        }else {
            inputError();
            return false;
        }
    }

    private boolean checkForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        }
        else {
            inputError();
            return false;
        }

    }

    public void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void findHumanByName(){
        System.out.println("Please enter the person's first and last name separated by a space");
        String fullname = scanner.nextLine();
        presenter.findHumanByName(fullname);

    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByGen(){
        presenter.sortByGen();
    }

    public void showList(){
        presenter.showList();
    }

    public void addHuman(){
        System.out.println("Please enter the person's ID (6 digits)");
        String idString = scanner.nextLine();
        int id = Integer.parseInt(idString);

        System.out.println("Please enter the person's first and last name separated by a space");
        String fullname = scanner.nextLine();

        System.out.println("Please enter the person's Gender (female or male)");
        String genderString = scanner.nextLine();
        Gender gender = genderString.equalsIgnoreCase("male") ? Gender.Male : Gender.Female;

        System.out.println("Please enter the person's date of birth (yyyy-mm-dd)");
        String dateOfBirthString = scanner.nextLine();
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        presenter.addHuman(id,fullname,gender,dateOfBirth);

    }

    public void finishHim(){
        System.out.println("See you again!");
        menuGo = false;
    }

}


