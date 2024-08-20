package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean isWork;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        isWork = true;
        menu = new MainMenu(this);

    }

    @Override
    public void start() {
        hello();
        while (isWork) {
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private void hello() {
        printAnswer("Доброго времени суток!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
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

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void inputError() {
        printAnswer(INPUT_ERROR);
    }

    public void finish() {
        printAnswer("До свидания");
        isWork = false;
    }

    public void addHuman() {
        String name;
        Gender gender;
        LocalDate birthDate;
        String strFormatter = "dd.MM.yyyy";
        printAnswer("Введите имя:");
        name = scanner.nextLine();
        printAnswer("Укажите пол\n1 - мужской, 2- женский");
        String sex = scanner.nextLine();
        while (!(sex.charAt(0) == '1' || sex.charAt(0) == '2')) {
            inputError();
            printAnswer("Укажите пол\n1 - мужской, 2- женский");
            sex = scanner.nextLine();
        }
        if (sex.equals("1"))
            gender = Gender.Male;
        else
            gender = Gender.Female;

        printAnswer("Введите дату рождения в формате " + strFormatter);
        String strDate = scanner.nextLine();
        while (strDate.length() != 10 && strDate.split(".").length != 3) {
            inputError();
            printAnswer("Введите дату рождения в формате " + strFormatter);
            strDate = scanner.nextLine();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(strFormatter);
        birthDate = LocalDate.parse(strDate, dateTimeFormatter);
        presenter.addHuman(name, gender, birthDate);
    }

    public void addParent() {
        String childName, parentName;
        int childId, parentId;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите имя ребёнка");
            childName = scanner.nextLine();
            printAnswer("Введите имя родителя");
            parentName = scanner.nextLine();
            presenter.addParent(childName, parentName);
        } else {
            printAnswer("Введите id ребёнка");
            childId = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите id родителя");
            parentId = Integer.parseInt(scanner.nextLine());
            presenter.addParent(childId, parentId);
        }
        presenter.getFamilyTreeInfo();
    }

    public void addChild() {
        String childName, parentName;
        int childId, parentId;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите имя родителя");
            parentName = scanner.nextLine();
            printAnswer("Введите имя ребёнка");
            childName = scanner.nextLine();
            presenter.addChild(parentName, childName);
        } else {
            printAnswer("Введите id родителя");
            parentId = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите id ребёнка");
            childId = Integer.parseInt(scanner.nextLine());
            presenter.addChild(parentId, childId);
        }
        presenter.getFamilyTreeInfo();
    }

    public void setWedding() {
        String name1, name2;
        int id1, id2;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите первое имя");
            name1 = scanner.nextLine();
            printAnswer("Введите второе имя");
            name2 = scanner.nextLine();
            presenter.setWedding(name1, name2);
        } else {
            printAnswer("Введите первый id");
            id1 = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите второй id");
            id2 = Integer.parseInt(scanner.nextLine());
            presenter.setWedding(id1, id2);
        }
    }

    public void setDivorce() {
        String name1, name2;
        int id1, id2;
        printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 1 || choice > 2) {
            inputError();
            printAnswer("Выберете способ добавления:\n1 - по имени; 2 - по id");
            choice = Integer.parseInt(scanner.nextLine());
        }
        if (choice == 1) {
            printAnswer("Введите первое имя");
            name1 = scanner.nextLine();
            printAnswer("Введите второе имя");
            name2 = scanner.nextLine();
            presenter.setDivorce(name1, name2);
        } else {
            printAnswer("Введите первый id");
            id1 = Integer.parseInt(scanner.nextLine());
            printAnswer("Введите второй id");
            id2 = Integer.parseInt(scanner.nextLine());
            presenter.setDivorce(id1, id2);
        }
    }

    public void getFamilyTreeinfo() {
        presenter.getFamilyTreeInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByBirthdate() {
        presenter.sortByBirthDate();
    }

    public void saveToFile() {
        String filename;
        String filePath = "src/model/writer/";
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        filePath += filename + ".txt";
        if (presenter.saveToFile(filePath))
            printAnswer("Файл " + filename + " успешно сохранен");
        else
            printAnswer("Ошибка сохранения");
    }

    public void loadFromFile() {
        String filename;
        String filePath = "src/model/writer/";
        printAnswer("Укажите имя файла");
        filename = scanner.nextLine();
        filePath += filename + ".txt";
        if (presenter.loadFromFile(filePath))
            printAnswer("Файл " + filename + " успешно загружен");
        else
            printAnswer("Ошибка загрузки");
    }
}
