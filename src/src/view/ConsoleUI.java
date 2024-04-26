package src.view;

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
    public void start() {
        // presenter.addPerson("v", Gender.male ,LocalDate.of(1987, 8, 7) );
        // presenter.addPerson("b", Gender.female ,LocalDate.of(1988, 10,3) );
        // presenter.addPerson("n", Gender.male ,LocalDate.of(2014, 4, 18) );
        while (work) {
            printAnswer(mainMenu.menu());
            execut();

        }
    }

    private void execut() {
        String input = scanner.nextLine();
        if (validationInput(input)) {
            mainMenu.execut(input);
        } else {
            printAnswer(ERROR_ENTER);
        }

    }

    public boolean validationInput(String text) {
        if (text.matches("[1-9]+")) {
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
        Gender gendr = null;
        // int year;
        // int mn;
        // int day;
        StringBuilder dt = new StringBuilder();

        printAnswer("Введите имя");
        String name = scanner.nextLine();
        printAnswer("Введите пол\n");
        // System.out.println("Где Ж - женский, а М - мужcкой"); // не считывает русскую
        // раскладку , найти решение
        boolean wrk = true;
        while (wrk) {
            printAnswer("Где 1 - женский, а 2 - мужcкой");
            String gender = scanner.nextLine();
            if (gender.contains("1")) {
                gendr = Gender.female;
                wrk = false;
            } else if (gender.contains("2")) {
                gendr = Gender.male;
                wrk = false;
            } else {
                printAnswer(ERROR_ENTER);
            }
        }
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
                    if (mn<10 && num.length()==1 ){
                        dt.append("0");
                        dt.append(mn);
                        dt.append("-");
                        wrk = false;
                    }else{                        
                    dt.append(num);
                    dt.append("-");
                    wrk = false;
                    } 
                }else {
                    printAnswer(ERROR_ENTER);
                }
            } else {
                printAnswer(ERROR_ENTER);
            }
        }
        wrk = true;
        while (wrk) {
            printAnswer("Введите день: ");
            String num = scanner.nextLine();
            if (isNumeric(num)) {
                int day = Integer.parseInt(num);
                if (0 < day && day < 32) {
                    if (day<10 && num.length()==1 ){
                        dt.append("0");
                        dt.append(day);
                        wrk = false; 
                    }else{
                        dt.append(num);
                        wrk = false;
                    }
                    
                } else {
                    printAnswer(ERROR_ENTER);
                }
            } else {
                printAnswer(ERROR_ENTER);

            }
        }

        LocalDate date = LocalDate.parse(dt.toString());

        if (presenter.addPerson(name, gendr, date)){
            printAnswer(COMPLETED);
        }else{
            printAnswer(ERROR_ENTER);
        }
    }

    public static boolean isNumeric(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        }else{
            return false;
        }
        
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

        if(presenter.kinship(inPut.toString())){
            printAnswer(COMPLETED);
        }else{
            printAnswer(ERROR_ENTER);
        }

    }

    public String enterString() {
        boolean wrk = true;
        while (wrk) {
            String name = scanner.nextLine();
            if (name == null || isNumeric(name)) {
                printAnswer(ERROR_ENTER);
            } else {
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
        if (presenter.sortByName()){
            printAnswer(COMPLETED);
        }else{
            printAnswer(ERROR_ENTER);
        }
    }

    public void sortByAge() {
        if (presenter.sortByAge()){
            printAnswer(COMPLETED);
        }else{
            printAnswer(ERROR_ENTER);
        }
    }

}
