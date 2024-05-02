package view;

import model.human.Gender;
import presenter.Presenter;

import java.io.IOException;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    final static String DATE_FORMAT = "dd.MM.yyyy";
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final MainMenu menu;

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
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void saveTree() throws IOException {
        presenter.saveTree();
    }

    public void downloadTree() throws IOException, ClassNotFoundException {
        presenter.downloadTree();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getMembersInfo() {
        presenter.getMembersInfo();
    }

    public void getChildrenInfo() {
        System.out.println("Введите id человека: ");
        String stringMemberId = scanner.nextLine();
        if (checkTextForInt(stringMemberId)) {
            int numMemberId = Integer.parseInt(stringMemberId);
            presenter.getChildrenInfo(numMemberId);
        }
    }

    public void addMember() {
        System.out.println("Введите имя члена семьи:");
        String name = scanner.nextLine();

        String dateString;
        do {
            System.out.println("Укажите дату рождения в формате dd.MM.yyyy:");
            dateString = scanner.nextLine();
        } while (!isDateValid(dateString));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);

        System.out.println("Укажиите пол (1-Ж, 2-М):");
        String genderString = scanner.nextLine();

        if (genderString.equals("1")) {
            Gender gender = Gender.Female;
            presenter.addMember(name, date, gender);
        } else if (genderString.equals("2")) {
            Gender gender = Gender.Male;
            presenter.addMember(name, date, gender);
        } else {
            inputError();
        }

    }

    public void addParent() {
        System.out.println("Введите id человека, кому нужно установить родителя: ");
        String stringMemberId = scanner.nextLine();

        if (checkTextForInt(stringMemberId)) {
            int numMemberId = Integer.parseInt(stringMemberId);
            System.out.println("Введите id родителя: ");
            String stringParentId = scanner.nextLine();
            if (checkTextForInt(stringParentId)) {
                int numParentId = Integer.parseInt(stringParentId);
                presenter.addParent(numMemberId, numParentId);
            }
        }
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
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

    public boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            inputError();
            return false;
        }
    }

}
