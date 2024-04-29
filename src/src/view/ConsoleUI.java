package src.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import src.model.Gender;
import src.presenter.Presenter;

public class ConsoleUI implements View {

    private final String ERROR_ENTER = "Ввод не корректен, попробуйте снова";
    private final String COMPLETED = "Выполнено";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() throws FileNotFoundException, IOException, ClassNotFoundException {
        while (work) {
            printAnswer(mainMenu.menu());
            execut();

        }
    }

    private void execut() throws FileNotFoundException, IOException, ClassNotFoundException {
        String input = scanner.nextLine();
        if (validationInput(input)) {
            mainMenu.execut(input);
        } else {
            printAnswer(ERROR_ENTER);
        }

    }

    public boolean validationInput(String text) {
        if (isNumeric(text)) {
            int num = Integer.parseInt(text);
            if (num <= mainMenu.getSize()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void printAnswer(String txt) {
        System.out.println(txt);

    }

    public void finish() {
        printAnswer("Завершение работы");
        work = false;
    }

    public void addPerson() {

        printAnswer("Введите имя");
        String name = enterString();
        Gender gendr = userGenderEntry();
        LocalDate date = userDateEntry();

        if (presenter.addPerson(name, gendr, date)) {
            printAnswer(COMPLETED);
        } else {
            printAnswer(ERROR_ENTER);
        }
    }

    private Gender userGenderEntry() {
        Gender gender = null;
        printAnswer("Введите пол\n");
        // System.out.println("Где Ж - женский, а М - мужcкой"); // не считывает русскую
        // раскладку , найти решение
        boolean wrk = true;
        while (wrk) {
            printAnswer("Где 1 - женский, а 2 - мужcкой");
            String gendr = scanner.nextLine();
            if (gendr.contains("1")) {
                gender = Gender.female;
                wrk = false;
            } else if (gendr.contains("2")) {
                gender = Gender.male;
                wrk = false;
            } else {
                printAnswer(ERROR_ENTER);

            }
        }
        return gender;
    }

    private LocalDate userDateEntry() {
        StringBuilder dt = new StringBuilder();
        boolean wrk;
        printAnswer("Введите дату рождения\n");
        wrk = true;
        while (wrk) {
            printAnswer("Введите год: ");
            String num = scanner.nextLine();
            if (isNumeric(num)) {
                int year = Integer.parseInt(num);
                if (year <= LocalDate.now().getYear()) {
                    dt.append(num);
                    dt.append("-");
                    wrk = false;
                } else {
                    printAnswer(ERROR_ENTER);
                }
            } else {
                printAnswer(ERROR_ENTER);
            }
        }
        wrk = true;
        while (wrk) {
            printAnswer("Введите месяц: ");
            String num = scanner.nextLine();

            if (isNumeric(num)) {
                int mn = Integer.parseInt(num);
                if (0 < mn && mn < 13) {
                    dateEntryCorrection(dt, num, mn);
                    wrk = false;
                } else {
                    printAnswer(ERROR_ENTER);
                }
            } else {
                printAnswer(ERROR_ENTER);
            }
        }
        dt.append("-");
        wrk = true;
        while (wrk) {
            printAnswer("Введите день: ");
            String num = scanner.nextLine();
            if (isNumeric(num)) {
                int day = Integer.parseInt(num);
                if (0 < day && day < 32) {
                    dateEntryCorrection(dt, num, day);
                    wrk = false;
                } else {
                    printAnswer(ERROR_ENTER);
                }
            } else {
                printAnswer(ERROR_ENTER);

            }
        }

        LocalDate date = LocalDate.parse(dt.toString());
        return date;
    }

    private StringBuilder dateEntryCorrection(StringBuilder dt, String num, int day) {

        if (day < 10 && num.length() == 1) {
            dt.append("0");
            dt.append(day);
        } else {
            dt.append(num);
        }
        return dt;
    }

    public void kinship() {
        printAnswer("Введите имя");
        printAnswer("Ребенка");
        StringBuilder inPut = new StringBuilder();

        inPut.append(enterString());
        inPut.append(" ");
        printAnswer("Введите имя");
        printAnswer("Отца");
        inPut.append(enterString());
        inPut.append(" ");
        printAnswer("Введите имя");
        printAnswer("Матери");
        inPut.append(enterString());
        inPut.append(" ");

        if (presenter.kinship(inPut.toString())) {
            printAnswer(COMPLETED);
        } else {
            printAnswer(ERROR_ENTER);
        }

    }

    public boolean isNumeric(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            return false;
        }

    }

    public String enterString() {
        boolean wrk = true;
        while (wrk) {
            String name = scanner.nextLine();
            if (name != null || isNumeric(name) != true) {
                wrk = false;
                return name;
            }
        }
        return ERROR_ENTER;

    }

    public void printList() {
        presenter.prinrtListInfo();
    }

    public void sortByName() {
        if (presenter.sortByName()) {
            printAnswer(COMPLETED);
        } else {
            printAnswer(ERROR_ENTER);
        }
    }

    public void sortByAge() {
        if (presenter.sortByAge()) {
            printAnswer(COMPLETED);
        } else {
            printAnswer(ERROR_ENTER);
        }
    }

    public void savingToFile() throws FileNotFoundException, IOException {
        printAnswer("Введите имя файла");
        String nameFile = scanner.nextLine();
        StringBuilder nF = new StringBuilder();
        nF.append(nameFile);
        nF.append(".");
        nF.append("out");
        if (presenter.savingToFile(nF.toString())) {
            printAnswer(COMPLETED);
        }
    }

    public void fileUpload() throws FileNotFoundException, ClassNotFoundException, IOException {
        printAnswer("Введите имя файла");
        String title = scanner.nextLine();
        StringBuilder fullTitle = new StringBuilder();
        fullTitle.append(title);
        fullTitle.append(".out");
        File file = new File(fullTitle.toString());

        if (file.exists()) {
            if (presenter.fileUpload(file)) {
                printAnswer(COMPLETED);
            }
        } else {
            printAnswer("Файл не существует");
        }

    }

}
