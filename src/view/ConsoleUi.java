package view;

import model.Human.Gender;
import model.Human.Human;
import presenter. Presenter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View{
    private Scanner scanner;
    private boolean work;
    private boolean ftwork;
    private Presenter presenter;
    private MainMenu menu;
    private FamilyTiesMenu ftmenu;

    public ConsoleUi(){
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        ftmenu = new FamilyTiesMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветсвуем в программе семейного древа!");

        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До свидания!");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getPersonListInfo() {
        presenter.getPersonListInfo();
    }

    public void addPerson() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();


        Gender gender = null;
        boolean inIsCorrect = false;
        while (!inIsCorrect){
            System.out.println("Укажите пол");
            System.out.println("1. Мужчина");
            System.out.println("2. Женщина");
            String genderStr = scanner.nextLine();
            switch (genderStr){
                case "1":
                    gender = Gender.мужчина;
                    inIsCorrect = true;
                    break;
                case "2":
                    gender = Gender.женщина;
                    inIsCorrect = true;
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }


        System.out.println("Укажите год рождения");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);

        System.out.println("Укажите номер месяца рождения");
        String monthStr = scanner.nextLine();
        int month = Integer.parseInt(monthStr);

        System.out.println("Укажите день рождения");
        String dayStr = scanner.nextLine();
        int day = Integer.parseInt(dayStr);

        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        presenter.addPerson(name,dateOfBirth, gender);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void writeTree() throws IOException {
        System.out.println("Введите имя файла для записи дерева");
        String filename = scanner.nextLine();

        presenter.writeTree(filename);
    }

    public void readTree() throws IOException, ClassNotFoundException {
        System.out.println("Введите имя файла для чтения дерева");
        String filename = scanner.nextLine();

        presenter.readTree(filename);
    }

    public void familyTies() {
        System.out.println("Какую родственную связь вы хотите назначить?");
        ftwork = true;
        while (ftwork){
            System.out.println(new FamilyTiesMenu(this).menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            ftmenu.execute(choice);
        }
    }

    public void setMother() {
        System.out.println("Метод пока не реализован");
    }

    public void setFather() {
        System.out.println("Метод пока не реализован");
    }

    public void addChild() {
        System.out.println("Метод пока не реализован");
    }

    public void toBaseMenu() {
        ftwork = false;
    }
}
