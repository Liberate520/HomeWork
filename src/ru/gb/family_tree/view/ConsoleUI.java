package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.presenter.Presenter;

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
    public void start(){

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
}
