package family_tree.view;

import family_tree.presenter.Presenter;
import family_tree.model.human.Gender;
import writer.Writer;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View, Writer {
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this,  this);
        menu = new MainMenu(this);

    }


    @Override
    public void start() throws IOException, ClassNotFoundException {
        System.out.println("HOWDY!");
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
//            System.out.println("1.Добавить человека");
//            System.out.println("2.Получить список семейного древа");
//            System.out.println("3.Добавить родителя/ребенка");
//            System.out.println("4.Добавить брак");
//            System.out.println("5.Сортировать по имени");
//            System.out.println("6.Сохранение в файл");
//            System.out.println("7.Открыть ранее сохраненный файл");
//            System.out.println("8.Выход");

//            String choice = scanner.nextLine();
//            switch (choice){
//                case "1":
//                    addHuman();
//                    break;
//                case "2":
//                    getHumanListInfo();
//                    break;
//                case "3":
//                    addParent();
//                    break;
//                case "4":
//                    addMarriage();
//                    break;
//                case "5":
//                    sortByName();
//                    break;
//                case "6":
//                    saveToFile()  ;
//                case "7":
//                    readFromFile()  ;
//                    break;
//                case "8":
//                    finish()  ;
//                    break;
//                default:
//                    System.out.println("Введено неверное значение!");

        }


    }

//    @Override
//    public void printAnswer(String answer) {
//
//    }
    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (male/female)");
        String gender1 = scanner.nextLine();
        Gender gender = parse(gender1);

        System.out.println("Укажите дату рождения  (в формате 01.01.1900)");
        String birthdate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(birthdate, formatter);

        presenter.addHuman(name,gender,date);
    }
    public void addParent() {
        System.out.println("Введите ID родителя:");
        String id = scanner.nextLine();
        Long parID = Long.parseLong(id);
        System.out.println("Введите ID ребенка:");
        String id1 = scanner.nextLine();
        Long chID = Long.parseLong(id1);

        presenter.addParent(parID,chID);
    }
    public void addMarriage() {
        System.out.println("Введите ID мужа:");
        String id = scanner.nextLine();
        Long human1 = Long.parseLong(id);
        System.out.println("Введите ID жены:");
        String id1 = scanner.nextLine();
        Long human2 = Long.parseLong(id1);

        presenter.addMarriage(human1,human2);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveToFile() throws IOException {
        presenter.saveToFile();
        System.out.println("Данные сохранены в файл .txt");
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        System.out.println(presenter.readFromFile()); ;
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До свидания!");
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);

    }

    public static Gender parse(String gender) {
        if (gender == null) {
            throw new IllegalArgumentException("Gender cannot be null");
        }
        try {
            return Gender.valueOf(gender.toLowerCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No enum constant " + gender);
        }
    }

    @Override
    public void save(Serializable serializable) throws IOException {

    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        return null;
    }
}


