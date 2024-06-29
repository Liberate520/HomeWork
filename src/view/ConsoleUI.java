package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.human.Gender;
import model.human.SpouseStatus;
import presenter.Presenter;
import view.menu.Menu;
import view.menu.MainMenu;
import view.menu.SortMenu;


public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели некорректные данные";

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private SortMenu sort_menu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
        sort_menu = new SortMenu(this);
    }


    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }


    @Override
    public void start() {
        while (work) {
            System.out.println("\nМеню:\n------------------ ");
            printMenu(menu);
            execute(menu);
        }
    }


    public void finish() {
        System.out.println("Работа приложения завершена.");
        work = false;
    }


    public void getFamilyTreeInfo() {
        printMenu(sort_menu);
        execute(sort_menu);
    }


    public void getNoSortTree(){ presenter.getFamilyTreeInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (в формате гггг-мм-дд): ");
        String dateString = scanner.nextLine();
        System.out.println("Введите пол (м/ж): ");
        String gen = scanner.nextLine().toLowerCase();
        Gender gender = null;
        if (gen.equals("м")) {
            gender = Gender.Male;
        }else if (gen.equals("ж")){
            gender= Gender.Female;
        }

        presenter.addHuman(name, gender, dateString);
    }


    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void setDeathDate() {
        this.getNoSortTree();
        System.out.println("----------------");
        System.out.println("Введите id члена семьи, для которого надо указать дату смерти.");
        int personId = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите дату смерти (в формате гггг-мм-дд): ");
        LocalDate deathDate = LocalDate.parse(scanner.nextLine());
        presenter.setDeathDate(personId, deathDate);
    }


    public void setParent() {

        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать родителя.");
        int memberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id родителя.");
        int parentId = Integer.parseInt(scanner.nextLine());
        presenter.setParent(memberId, parentId);
    }


    public void setSpouse() {
        this.getNoSortTree();
        System.out.println("Введите id члена семьи, для которого надо указать супруга(у). ");
        int firstMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id супруга(и).");
        int secondMemberId = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите статус супругов (ex/actual): ");
        SpouseStatus spouseStatus = SpouseStatus.valueOf(scanner.nextLine());
        presenter.setSpouse(firstMemberId, secondMemberId, spouseStatus);
    }


    public void read() {
        String file = "src/model/save_and_load/tree.txt";
        while (!presenter.read(file)) {
            System.out.println("Не удалось загрузить файл. Будете пробовать снова? y/n: ");
            if (scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для чтения информации по дереву\n(Например: src/save_and_load/tree.txt): ");
            file = scanner.nextLine();
        }
    }


    public void save() {
        String file = "src/model/save_and_load/tree.txt";
        while(!presenter.save(file)) {
            System.out.println("Не удалось сохранить файл. Будете пробовать снова? y/n");
            if(scanner.nextLine().equals("n")) {
                break;
            }
            System.out.println("Укажите путь к файлу для сохранения информации по дереву\n(Например: src/save_and_load/tree.txt): ");
            file = scanner.nextLine();
        }
    }

    private void execute(Menu menu) {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu)) {
                menu.execute(numCommand);
            }
        }
    }


    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }


    private boolean checkCommand(int numCommand, Menu menu) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu) {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

}

