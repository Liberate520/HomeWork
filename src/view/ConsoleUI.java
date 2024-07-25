package view;

import model.Humans.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private FamilyMenu familyMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        familyMenu = new FamilyMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в проект 'Семейное древо'. " +
                "Выберите пожалуйста команду из списка:");
        while (work) {
            System.out.println(familyMenu.familyMenu());
            String line = scanner.nextLine();
            if (checkTextForInt(line)){
                int numCommand = Integer.parseInt(line);
                if (checkCommand(numCommand)){
                    familyMenu.execute(numCommand);
                }
            }
        }
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public LocalDate addBornDate(){
        System.out.println("Введите дату рождения родственника (год, месяц, день через -):");
        return LocalDate.parse(scanner.next());
    }

    public LocalDate addDeathDate() {
        System.out.println("Введите дату смерти родственника (год, месяц, день через -):");
        return LocalDate.parse(scanner.next());
    }

    public void addHuman() {
        System.out.println("Введите ФИО родственника: ");
        String name = scanner.nextLine();

        System.out.println("Введите пол родственника: ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.valueOf(strGender);



        presenter.addHuman(name, gender, addBornDate(), addDeathDate());
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
        if (numCommand <= familyMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void inputError(){
        System.out.println("INPUT_ERROR");
    }

    public void stopProgram() {
        work = false;
        scanner.close();
        System.out.println("Возвращайтесь!");

    }

    public void saveTree() {
        presenter.saveTree();
    }

    public void loadTree() {
        presenter.loadTree();
    }

    public void setParents(){
        System.out.println("Введите ID ребёнка: \n");
        String childStr = scanner.nextLine();
        int childID = Integer.parseInt(childStr);

        System.out.println("Введите ID отца: \n");
        String fatherStr = scanner.nextLine();
        int fatherID = Integer.parseInt(fatherStr);

        System.out.println("Введите ID матери: \n");
        String motherStr = scanner.nextLine();
        int motherID = Integer.parseInt(motherStr);

        presenter.setParents(childID, fatherID, motherID);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
