package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
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
    public void start() {
        System.out.println("Greetings!");
        while (work){
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            //TODO: метод проверки на валидность
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void finish() {
        System.out.println("Thank you for using this program.");
        work = false;
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void createDefaultFamilyTree(){
        presenter.createDefaultFamilyTree();
    }

    public void addHuman() {
        System.out.println("Enter human name: ");
        String name = scanner.nextLine();

        System.out.println("Enter human gender (Male/Female): ");
        String strGender = scanner.nextLine();
        //TODO: Add validity testing methods
        Gender gender = Gender.valueOf(strGender);

        System.out.println("Enter human birthDate in the format dd.MM.yyyy: ");
        String strBirthdate = scanner.nextLine();
        //TODO: Add validity testing methods
        LocalDate birthDate = LocalDate.parse(strBirthdate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Enter human date of death in the format dd.MM.yyyy ");
        System.out.println("or continue without entering: ");
        String strDeathdate = scanner.nextLine();
        //TODO: Add validity testing methods
        LocalDate deathDate = null;
        if (strDeathdate != "") {
            deathDate = LocalDate.parse(strDeathdate, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        presenter.addHuman(name, gender, birthDate, deathDate);
    }

    public void save(){
        presenter.save();
    }

    public void read (){
        presenter.read();
    }

    private void error() {
        System.out.println("Invalid input. Try again.");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
