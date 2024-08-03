package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    private AddHumanDataMenu addDataMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        addDataMenu = new AddHumanDataMenu(this);
        work = true;
    }

    @Override
    public void printAnswer(String answer) {
        System.err.println(answer);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        goodbye();
        work = false;
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            numCommand--;
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
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

    private boolean checkTextForInt(String line) {
        if (line.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void startAddDataMenu() {
        helloAddDataMenu();
        printAddDataMenu();
        executeAddDataMenu();
    }

    private void executeAddDataMenu() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            numCommand--;
            if (checkCommandAddDataMenu(numCommand)) {
                addDataMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommandAddDataMenu(int numCommand) {
        if (numCommand <= addDataMenu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void setHumanSpouse() {
        System.out.println("Супруг");
        int humanId = idRequest();
        System.out.println("Супруга");
        int spouseId = idRequest();
        presenter.setHumanSpouse(humanId, spouseId);
    }

    public void setHumanParents() {
        System.out.println("Ребенок");
        int humanId = idRequest();
        System.out.println("Отец");
        int fatherId = idRequest();
        System.out.println("Мать");
        int motherId = idRequest();
        presenter.setHumanParents(humanId, fatherId, motherId);
    }

    public void setDateOfDeath() {
        int id = idRequest();
        int year = yearRequest();
        int month = monthRequest();
        int day = dayRequest();
        presenter.setDateOfDeath(id, year, month, day);
    }

    private int idRequest() {
        int id = -1;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите id: ");
            int answer = scanner.nextInt();
            if (presenter.isInFamilyTree(answer)) {
                id = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return id;
    }

    public void addHuman() {
        String name = nameRequest();
        int genderChoice = genderChoice();
        int year = yearRequest();
        int month = monthRequest();
        int day = dayRequest();
        presenter.addHuman(name, genderChoice, year, month, day);
    }

    private int dayRequest() {
        int day = 1;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите день: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer < 32) {
                day = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return day;
    }

    private int monthRequest() {
        int month = 1;
        boolean flag = true;
        while (flag) {
            System.out.println("Введите месяц: ");
            int answer = scanner.nextInt();
            if (answer > 0 && answer < 13) {
                month = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return month;
    }

    private int yearRequest() {
        System.out.println("Введите год: ");
        int year = scanner.nextInt();
        return year;
    }

    private String nameRequest() {
        System.out.println("Введите имя человека: ");
        String name = scanner.nextLine();
        return name;
    }

    private int genderChoice() {
        boolean flag = true;
        int gender = 1;
        while (flag) {
            System.out.println("Введите пол: 1 - мужской, 2 - женский");
            int answer = scanner.nextInt();
            if (answer == 1 || answer == 2) {
                gender = answer;
                flag = false;
            } else {
                inputError();
            }
        }
        return gender;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveFamilyTreeData() {
        presenter.saveFamilyTree();
    }

    public void loadFamilyTreeData() throws ClassNotFoundException {
        presenter.loadFamilyTree();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    private void inputError() {
        System.out.println("Введены неверные данные\n");
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void printAddDataMenu() {
        System.out.println(addDataMenu.menu());
    }

    private void hello() {
        System.out.println("Приветствую вас!");
    }

    private void helloAddDataMenu() {
        System.out.println("Меню добавления данных и связей");
    }

    private void goodbye() {
        System.out.println("До скорых встреч!");
    }
}