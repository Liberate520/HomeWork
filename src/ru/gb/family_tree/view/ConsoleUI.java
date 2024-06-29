package ru.gb.family_tree.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import ru.gb.family_tree.model.item.Gender;
import ru.gb.family_tree.model.item.Human;
import ru.gb.family_tree.presenter.Presenter;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение!\nНеобходимо ввести целое число от 1 до";
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
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До встречи!\n");
        work = false;
    }

    public void sortById() {
        presenter.sortById();
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

    public void addTreeItem() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (1 - мужской, 2 - женский):");
        String genderString = scanner.nextLine();
        Gender gender = setGender(genderString);
        LocalDate birthDate = setDate("рождения");
        LocalDate deathDate = setDate("смерти");        

        /***** TODO ДОБАВИТЬ МЕТОДЫ СОЗДАНИЯ РОДСТВЕННЫХ СВЯЗЕЙ ******/

        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();
        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();
        // System.out.println("Укажите дату рождения:");
        // String ageString = scanner.nextLine();

        Human father = null;
        Human mother = null;
        presenter.addItem(name, gender, birthDate, deathDate, father, mother);
    }

    // private void addRelative() {

    //     System.out.println("Выберите из списка id члена древа, которому будем добавлять родственников:");
    //     String line = scanner.nextLine();
    //     if (checkTextForInt(line)) {
    //         int id = Integer.parseInt(line);
    //         Human human = presenter.getById(id);
    //         if (checkCommand(numCommand)) {
    //             menu.execute(numCommand);
    //         }
    //     }        
    // }

    private void addToChildren(Human child) {
        presenter.addToChildren(child);
    }

    private void hello() {
        System.out.println("Вас приветствует мастер создания генеалогического древа!");
    }

    private void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private Gender setGender(String text) {
        Gender gender;
        if (text.equals("1")) {
            gender = Gender.Male;
        } else if (text.equals("2")) {
            gender = Gender.Female;
        } else {
            System.out.println("Пол не определён)))");
            return null;
        }
        return gender;
    }

    private LocalDate setDate(String st) {
        String text;
        LocalDate result = null;
        boolean notDate = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (notDate) {
            System.out.print("Укажите дату " + st + " в формате \"гггг-ММ-дд\":");
            if (st.equals("смерти"))
                System.out.println("\n(если неизвестна - нажмите Enter)");
            text = scanner.nextLine();
            if (text != "") {
                try {
                    result = formatter.parse(text, LocalDate::from);
                    notDate = false;
                } catch (DateTimeParseException e) {
                    System.out.println("Вы ввели некорректную дату!");
                }
            } else if (st.equals("смерти")) {
                return null;
            }
        }
        return result;
    }

    private boolean checkTextForInt(String text) {
        if (!(text == "") && text.matches("[0-9]*")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR + " " + menu.getSize() + "\n");
    }
}