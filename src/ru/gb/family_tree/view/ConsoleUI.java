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
    private boolean play;
    private MenuMain menuMain;
    private int idRelative;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menuMain = new MenuMain(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws FileNotFoundException, ClassNotFoundException, IOException {
        hello();
        while (work) {
            playMenu(menuMain);
        }
    }

    public void startSubMenu() throws FileNotFoundException, ClassNotFoundException, IOException {
        System.out.println("Добавляем родственные связи...");
        Menu menu = new MenuAddRelative(this);
        play = true;
        while (play) {
            playMenu(menu);
        }
    }

    void playMenu(Menu menu) throws FileNotFoundException, ClassNotFoundException, IOException {
        printMenu(menu);
        execute(menu);
    }

    private void hello() {
        System.out.println("Вас приветствует мастер создания генеалогического древа!");
    }

    private boolean checkTextForInt(String text) {
        if (!(text == "") && text.matches("[0-9]*")) {
            return true;
            // } else {
            // inputError(menu);
            // return false;
        }
        return false;
    }

    // private boolean checkId(int id) {
    // if (!(text == "") && text.matches("[0-9]*")) {
    // return true;
    // } else {
    // inputError(menu);
    // return false;
    // }
    // }

    private boolean checkCommand(Menu menu, int numCommand) {
        if ((numCommand > 0) && (numCommand <= menu.getSize())) {
            return true;
        } else {
            inputError(menu);
            return false;
        }
    }

    private boolean checkId(int id) {
        int size = presenter.getSizeOfTree();
        if (id <= size - 1) {
            return true;
        } else {
            System.out.println("Введите целое число от 0 до " + size);
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError(Menu menu) {
        System.out.println(INPUT_ERROR + " " + menu.getSize() + "\n");
    }

    private void execute(Menu menu) throws FileNotFoundException, ClassNotFoundException, IOException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(menu, numCommand)) {
                menu.execute(numCommand);
            }
        } else {
            inputError(menu);
        }
    }

    public void finish() {
        System.out.println("Работа с древом завершена!\n" +
                "Вы хотите сохранить его в файл?\n" +
                "Если да - нажмите Enter,\n" +
                "для выхода - любую клавишу.");
        // ТОDO Enter - сохранение, любая клавиша - выход
        work = false;
    }

    public void exitMenu() {
        play = false;
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

    public void addTreeItem() throws FileNotFoundException, ClassNotFoundException, IOException {
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

        // addRelative();

    }

    public void addRelative() throws FileNotFoundException, ClassNotFoundException, IOException {
        if (presenter.getSizeOfTree() > 1) {
            // MenuAddRelative menu = new MenuAddRelative(this);
            System.out.println("Выберите из списка id члена древа, которому будем добавлять родственников:");
            // TODO если check Norm, вызов меню добавления родственников, иначе - возврат в
            // основное меню.
            String line = scanner.nextLine();
            if (checkTextForInt(line)) {
                idRelative = Integer.parseInt(line);
                if (checkId(idRelative)) {
                    startSubMenu();
                    // Human human = presenter.getById(id);
                    // menuAddRelative.execute(numCommand);
                }
            }
        }
    }

    public void addChild() {
        // Human human;
        // Human child;
        // System.out.println("Выберите ID родителя в семейном древе:");
        // String strId = scanner.nextLine();
        // if (checkTextForInt(strId)) {
        // int idParent = Integer.parseInt(strId);
        // if (checkId(idParent)) {
        System.out.println("Выберите ID ребёнка в семейном древе:");
        String strId = scanner.nextLine();
        if (checkTextForInt(strId)) {
            int idChild = Integer.parseInt(strId);
            if (checkId(idChild)) {
                presenter.addChild(idRelative, idChild);
                presenter.getTreeInfo();
                return;
            }
        }
        System.out.println("Необходимо ввести челое число от 0 до " + presenter.getSizeOfTree());
    }

    public void addParent() {
        System.out.println("Выберите ID родителя в семейном древе:");
        String strId = scanner.nextLine();
        if (checkTextForInt(strId)) {
            int idParent = Integer.parseInt(strId);
            if (checkId(idParent)) {
                presenter.addParent(idRelative, idParent);
                // presenter.getTreeInfo();
                return;
            }
        }
        System.out.println("Необходимо ввести челое число от 0 до " + presenter.getSizeOfTree());
    }     

    public void addSpouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSpouse'");
    }

    public void addSibling() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSibling'");
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

}