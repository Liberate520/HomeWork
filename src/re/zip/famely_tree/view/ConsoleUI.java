package re.zip.famely_tree.view;

import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleUI implements View {

    private final InputOutput io;
    private Presenter presenter;
    boolean workFlag;
    private MainMenu mainMenu;
    private final Scanner scanner;

    public ConsoleUI(InputOutput io) {
        this.io = io;
        presenter = new Presenter(this);
        workFlag = true;
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        while (workFlag) {
            io.println(mainMenu.getMenu());
            String strYourChoice = io.readLine();
            int choice = parseInt(strYourChoice);
            mainMenu.execute(choice);
        }
    }

    public void finish() {
        io.println("Работа закончена. До новых встреч");
        workFlag = false;
    }

    @Override
    public void printAnswer(String text) {
        io.println(text);
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByFirstName() {
        presenter.sortByFirstName();
    }

    public void sortByFamelyName() {
        presenter.sortByFamelyName();
    }

    public void getFamelyListInfo() {
        presenter.getFamelyListInfo();
    }

    public void addHumanToFamelyTree() {
        System.out.println("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();

        System.out.println("Введите дату рождения(в формате: XXXX-YY-ZZ, где XXXX - год, YY - месяц, ZZ - день): ");
        String strLocalDate = scanner.nextLine();
        LocalDate localDate = LocalDate.parse(strLocalDate);

        System.out.println("Ввендите пол(Male/Female): ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.valueOf(strGender);

        presenter.addHumanToFamelyTree(firstName, lastName, localDate, gender);
    }


    public void saveToFile(String filePath) {
        presenter.saveToFile(filePath);
    }

    public void loadFromFile(String filePath) {
        presenter.loadFromFile(filePath);
    }

    public void SetWeddding() {
        System.out.println("Введите ID номер первого из супругов: ");
        String strPartner1ID = scanner.nextLine();
        Integer partner1ID = parseInt(strPartner1ID);

        System.out.println("Введите ID номер вторго из супругов: ");
        String strPartner2ID = scanner.nextLine();
        Integer partner2ID = parseInt(strPartner2ID);

        System.out.println("Менялась ли фамилия супругов(0 - нет, 1 - взята фамилия первого супруга, 2 - взята фамилия второго супруга: ");
        String strNewFamelyName = scanner.nextLine();
        Integer getFamelyName = parseInt(strNewFamelyName);

        presenter.setWeddding(partner1ID, partner2ID, getFamelyName);
    }
}