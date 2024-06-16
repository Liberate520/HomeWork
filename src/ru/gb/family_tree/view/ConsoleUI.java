package ru.gb.family_tree.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import ru.gb.family_tree.model.item.FamilyTreeItem;
import ru.gb.family_tree.model.item.Gender;
import ru.gb.family_tree.presenter.Presenter;

public class ConsoleUI<E extends FamilyTreeItem<E>> implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение!\n";
    private Scanner scanner;
    @SuppressWarnings("rawtypes")
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter<>(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До встречи!\n");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortBySpouse() {
        presenter.sortBySpouse();
    }  

    public void loadTree() throws FileNotFoundException, ClassNotFoundException, IOException {
        presenter.loadTree();
    }       

    public void saveTree() throws FileNotFoundException, IOException {
        presenter.saveTree();
    }     

    public void getTreeInfo() {
        presenter.getTreeInfo();
    }

    @SuppressWarnings("unchecked")
    public void addTreeItem() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (1 - мужской, 2 - женский):");
        String genderString = scanner.nextLine();
        Gender gender = null;

        if (genderString.equals("1")) {
            gender = Gender.Male;
        } else if (genderString.equals("2")) {
            gender = Gender.Female;
        } else {
            System.out.println("Пол не определён)))");
        }

        System.out.println("Укажите дату рождения в формате \"гггг-ММ-дд\":");
        String birthDateString = scanner.nextLine();
        LocalDate birthDate = null;        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            birthDate = formatter.parse(birthDateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }

        System.out.println("Укажите дату смерти (если неизвестна - нажмите Enter):");
        String deathDateString = scanner.nextLine();
        LocalDate deathDate = null;

        if (deathDateString != "") {
            try {
                deathDate = formatter.parse(deathDateString, LocalDate::from);
            } catch (DateTimeParseException e) {
                e.printStackTrace();
            }
        } else {
            deathDate = null;
        }


        /*****   TODO ДОБАВИТЬ МЕТОДЫ СОЗДАНИЯ РОДСТВЕННЫХ СВЯЗЕЙ   ******/

        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();
        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();
        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();   

        E father = null;
        E mother = null;
        presenter.addItem(name, gender, birthDate, deathDate, father, mother);
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]*")){
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
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}