package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI  implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
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
    public void sortHumansByName(){
        presenter.sortHumansByName();
        presenter.getHumanInfo(2);
    }
    public  void getHumanInfo(){
        presenter.getHumanInfo(1);
    }
    public void addHuman() {
        Gender gender;
        LocalDate dod = null;
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате гггг-мм-дд :");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);
        System.out.println("Укажите дату смерти в формате гггг-мм-дд либо enter :" );
        String dodString = scanner.nextLine();
        if (!dodString.equals("")) {
            dod = LocalDate.parse(dodString);
        }
        System.out.println("Укажите 1 если пол мужской или 2 если женский :" );
        String genderString = scanner.nextLine();
        if (genderString == "1"){
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        System.out.println("Укажите id отца если он есть :" );
        String idFather = scanner.nextLine();
        System.out.println("Укажите id матери если она есть :" );
        String idMather = scanner.nextLine();
        presenter.addHuman(name, dob, dod, gender, idFather, idMather);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Добро пожаловать, выберите пункт меню :");
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

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void sortHumansByDOB() {
        presenter.sortHumansByDOB();
        presenter.getHumanInfo(3);
    }

    public void searhHumansByName() {
        System.out.println("Введите имя человека для поиска");
        String line = scanner.nextLine();
        presenter.searhHumansByName(line);
    }
    public void finish(){
        System.out.println("Спасибо за работу");
        work = false;
    }

}
