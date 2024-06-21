package ru.gb.family_tree.view;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
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
        System.out.println("Привествую!");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            //метод проверки данных на валидность
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void addHuman(){
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (Male/Female): ");
        String genderInput = scanner.nextLine();
        Gender gender = Gender.valueOf(genderInput.toUpperCase());
        System.out.println("Введите дату рождения: ");
        String birthDateInput = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateInput);
    }

    public void findHumanByName(){
        System.out.println("Введите имя человека для поиска: ");
        String nameHuman = scanner.nextLine();
        presenter.findHumanByName(nameHuman);
        getFamilyTree();
    }

    public void getFamilyTree(){
        presenter.getFamilyTree();
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
        getFamilyTree();
    }

    public void sortByName() {
        presenter.sortByName();
        getFamilyTree();
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
