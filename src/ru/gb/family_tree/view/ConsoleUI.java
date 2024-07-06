package ru.gb.family_tree.view;

import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.presenter.Presenter;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommang = Integer.parseInt(line);
            if (checkCommand(numCommang)){
                menu.execute(numCommang);
            }
        }
    }

    private boolean checkCommand(int numCommang) {
        if (numCommang <= menu.getSize()){
            return true;
        }
        else {
            inputError();
            return false;
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
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Добро пожаловать!");
    }
    public void addMember(){
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите имя матери или null: ");
        Member mother = presenter.findMember(scanner.nextLine());
        System.out.print("Введите имя отца или null: ");
        Member father = presenter.findMember(scanner.nextLine());
        System.out.print("Введите дату рождения год/месяц/дата или null: ");
        LocalDate birthDate = checkdate(scanner.nextLine());
        System.out.print("Введите дату смерти год/месяц/дата или null: ");
        LocalDate deathDate = checkdate(scanner.nextLine());
        System.out.print("Введите пол M / F ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        presenter.addMember(name, mother, father, birthDate, deathDate, gender);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public LocalDate checkdate(String sdate){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(sdate, formatter);
            return date;
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: неверный формат даты.");
        }
        return null;
    }

    public void getFullTree() {
        System.out.println(presenter.getFullTree());
    }

}
