package OOP.SemDZ.homeWork.view;

import java.time.LocalDate;
import java.util.Scanner;

import OOP.SemDZ.homeWork.model.human.Gender;
import OOP.SemDZ.homeWork.presenter.Presenter;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work = true;
    private MainMenu menu;

    public ConsoleUI () {
        scanner = new Scanner (System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start () {
        System.out.println("Hello");
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish(){

        System.out.println("Работа завершена. Bay!!!");
        work = false;
    }

    public void birthChildren(){
        System.out.println("Укажите имя ребенка: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (1 - мужской/2-женский): ");
        String genderStr = scanner.nextLine();
        System.out.println("Введите дату рождения:");
        System.out.println("Число: ");
        String dateStr = scanner.nextLine();
        System.out.println("Месяц: ");
        String monthStr = scanner.nextLine();
        System.out.println("Год: ");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dateStr);
        System.out.println("Введите ID отца");
        String IdFather = scanner.nextLine();
        System.out.println("Введите ID матери");
        String IdMather = scanner.nextLine();

        presenter.birthChildren(name, addGender(genderStr), LocalDate.of(year, month, day), IdFather, IdMather);
    }

    public void wedding(){
        System.out.println("Введите ID жениха");
        String IdMale = scanner.nextLine();
        System.out.println("Введите ID невесты");
        String IdFemale = scanner.nextLine();
        presenter.wedding(IdMale, IdFemale);
    }

    public void loadOfFile(){
        presenter.loadOfFile();
    }

    public void saveToFile(){
        presenter.saveToFile();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void printFamilyTree(){
        System.out.println(presenter.printFamilyTree());
    }

    public void addHuman(){

        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол (1 - мужской/2-женский): ");
        String genderStr = scanner.nextLine();
        System.out.println("Введите дату рождения:");
        System.out.println("Число: ");
        String dateStr = scanner.nextLine();
        System.out.println("Месяц: ");
        String monthStr = scanner.nextLine();
        System.out.println("Год: ");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr);
        int day = Integer.parseInt(dateStr);

        presenter.addHuman(name, addGender(genderStr), LocalDate.of(year, month, day));
    }

    public Gender addGender (String genderStr){
        if (genderStr.equals("1")){
            return Gender.Male;
        }
        else if (genderStr.equals("2")){return Gender.Female;}
        else return null;      

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
        System.out.println(menu.menuPrint());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);        
    }
    

}
