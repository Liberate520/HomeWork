package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
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
    public void start() {
        hello();
        presenter.readTree();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void sortHumansByName() {
        presenter.sortHumansByName();
        printAnswer(presenter.getHumanInfo(2));
    }

    public void getHumanInfo() {
        printAnswer(presenter.getHumanInfo(1));
    }

    public void addHuman() {

        Gender gender;
        LocalDate dod = null;
        printAnswer("Введите имя человека");
        String name = scanner.nextLine();
        printAnswer("Укажите дату рождения в формате гггг-мм-дд :");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);
        printAnswer("Укажите дату смерти в формате гггг-мм-дд либо enter :");
        String dodString = scanner.nextLine();
        if (!dodString.equals("")) {
            dod = LocalDate.parse(dodString);
        }
        printAnswer("Укажите 1 если пол мужской или 2 если женский :");
        String genderString = scanner.nextLine();
        if (Integer.parseInt(genderString) == 1) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        printAnswer("Укажите id отца если он есть :");
        String idFather = scanner.nextLine();
        printAnswer("Укажите id матери если она есть :");
        String idMather = scanner.nextLine();
        presenter.addHuman(name, dob, dod, gender, idFather, idMather);
    }

    private void printMenu() {
        printAnswer(menu.menu());
    }

    private void hello() {
        printAnswer("Добро пожаловать, выберите пункт меню :");
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

    private void inputError() {
        printAnswer(INPUT_ERROR);
    }

    public void sortHumansByDOB() {
        presenter.sortHumansByDOB();
        printAnswer(presenter.getHumanInfo(3));
    }

    public void searhHumansByName() {
        printAnswer("Введите имя человека для поиска");
        String line = scanner.nextLine();


        if (presenter.searhHumansByName(line).size() == 0) {
            printAnswer("Людей с таким именем не найдено");
        } else {
            printAnswer("По запросу по имени " + line + " надено следующее : ");
            for (String foundHuman : presenter.searhHumansByName(line)) {
                printAnswer(foundHuman);
            }
        }

    }

    public void finish() {
        printAnswer("Сохранить данные?\n 1 - если да 2 - если нет");
        String line = scanner.nextLine();
        if (Integer.parseInt(line) == 1) {
            presenter.saveTree();
        }

        printAnswer("Спасибо за работу");

        work = false;
    }

    public void searhHumansChild() {
        printAnswer("Введите id человека для поиска его детей");
        String line = scanner.nextLine();
        String foundHuman = presenter.searhHumansById(line);
        if (foundHuman == "false") {
            printAnswer("Человека с таким id в древе не существует");
        } else if (presenter.searhHumansChild(line).isEmpty()) {
            printAnswer("У " + foundHuman + " детей в древе не найдено");
        } else {
            printAnswer("Для " + foundHuman + " надены следующие дети: ");
            for (String foundHumansChild : presenter.searhHumansChild(line)) {
                printAnswer(foundHumansChild);
            }
            printAnswer("");
        }
    }
}
