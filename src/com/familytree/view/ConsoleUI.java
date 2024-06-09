package com.familytree.view;

import com.familytree.model.family_tree.FamilyTreeModel;
import com.familytree.model.human.Human;
import com.familytree.presenter.FamilyTreePresenter;

//import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private FamilyTreePresenter familyTreePresenter;
    private boolean work;
    private MainMenu mainMenu;
//    private Human human;

    public ConsoleUI() {
        List<Human> humans = new ArrayList<Human>();
        FamilyTreeModel model = new FamilyTreeModel();
        FamilyTreeView view = new FamilyTreeView(humans);
        familyTreePresenter = new FamilyTreePresenter(model, view);
        mainMenu = new MainMenu(this, familyTreePresenter);
        scanner = new Scanner(System.in);
        work = true;
    }

    public void start(){
        System.out.println("Приветствую!");

        while (work){
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }
    }

    public void finish(){
        work = false;
        System.out.println("До новых встреч!");
    }

    public void addHuman(){
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате dd.MM.yy)");
        String birthDateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
        LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);


        Human human = new Human(name, birthDate);
        familyTreePresenter.addHuman(human);
    }

    public void sortByName(){
        familyTreePresenter.sortByName();
    }

    public void sortByBirthDate(){
        familyTreePresenter.sortByBirthDate();
    }

    public void getHumanListInfo(){
        familyTreePresenter.getHumanListInfo();
    }

    public void printAnswer(String answer){
        System.out.println(answer);
    }
}
