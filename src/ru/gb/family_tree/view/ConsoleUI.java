package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConsoleUI implements View{

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
    public void printAnswer(String text){
        System.out.println(text);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void addHuman(){
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ:");
        String birth = scanner.nextLine();
        System.out.println("Введите пол в формате М/Ж:");
        String genderString = scanner.nextLine();
        Gender gender = Gender.Female;
        if(genderString.equals("М")){
            gender = Gender.Male;
        }
        presenter.addHuman(name, birth, gender);
    }

    public void addChildren() {
        System.out.println("Введите имя родителя:");
        String parent = scanner.nextLine();
        System.out.println("Введите имя ребенка:");
        String child = scanner.nextLine();
        presenter.addChildren(parent, child);
    }

    public void addSpouse() {
        System.out.println("Введите имя первого супруга:");
        String spouseFirst= scanner.nextLine();
        System.out.println("Введите имя второго супруга:");
        String spouseSecond = scanner.nextLine();
        presenter.addSpouse(spouseFirst, spouseSecond);
    }

    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void saveToFile() throws IOException {
        presenter.saveFileByte();
    }

    public void loadFile() throws IOException, ClassNotFoundException {
        presenter.loadFileByte();
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    private void execute() throws IOException, ClassNotFoundException {
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
}

