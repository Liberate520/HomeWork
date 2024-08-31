package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
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
        while (work){
            printMenu();
            execute();
        }
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand<=menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private boolean checkTextForInt(String line) {
        if (line.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол: MALE - 1/FEMALE - 2");
        Gender gender = findGender(scanner.nextLine());
        System.out.println("Укажите дату рождения - формат: дд.ММ.гггг");
        String ageString = scanner.nextLine();
        LocalDate birthday = LocalDate.parse(ageString, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
//        int age = Integer.parseInt(ageString);
//        LocalDate today = LocalDate.now();
//        LocalDate birthday = today.minusYears(age);

        presenter.addHuman(name, gender, birthday);
    }

    private Gender findGender(String gender){
        Gender gender1 = Gender.MALE;
        Gender gender2 = Gender.FEMALE;
        if (gender.equals("1")){
            return gender1;
        } else if (gender.equals("2")) {
          return gender2;
        } else {
            System.out.println(INPUT_ERROR);
        }
        return gender1;
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    public void finish(){
        System.out.println("Приятно было пообщатся!");
        work = false;
    }

    public void setWedding(){
        System.out.println("Введите имя первого человека");
        String human1 = scanner.nextLine();
        System.out.println("Введите имя второго человека");
        String human2 = scanner.nextLine();
        presenter.setWedding(human1, human2);
        presenter.getPeopleInfo();
    }

    public void sortByAge(){
        presenter.sortByAge();
        presenter.getPeopleInfo();
    }

    public void sortByName(){
        presenter.sortByName();
        presenter.getPeopleInfo();
    }

    public void getPeopleInfo(){
        presenter.getPeopleInfo();
    }

    public void save() {
        System.out.println("Введите путь к файлу для сохранения");
        String filePath = scanner.nextLine();
        presenter.setFilePath(filePath);
        presenter.save();
    }

    public void load() {
        System.out.println("Введите путь для загрузки файла");
        String filePath = scanner.nextLine();
        presenter.setFilePath(filePath);
        presenter.load();
    }
}
