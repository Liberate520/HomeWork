package re.zip.famely_tree.view;

import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    boolean workFlag;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        workFlag = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (workFlag) {
            System.out.println(mainMenu.getMenu());
            String strYourChoise = scanner.nextLine();
            int choise = parseInt(strYourChoise);
            mainMenu.execute(choise);
        }
    }

    public void finish() {
        scanner.close();
        System.out.println("Работа закончена. До новых встреч");
        workFlag = false;

    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

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