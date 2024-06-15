package View;

import Model.Human.Gender;
import Model.Human.Human;
import PresenterF.Presenter;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String NEW_ATTEMPT_MESSAGE = "Ошибка ввода, попробуйте снова";
    private static final String INPUT_ERROR = "Введено не правильное значение";
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

    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    private void hello() {
        System.out.println("Добрый день!");
    }

    private void bye() {
        System.out.println("До свидания");
    }

    public void finish() {
        bye();
        work = false;
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkLine(line)) {
            int command = Integer.parseInt(line);
            if (checkCommand(command)) {
                menu.execute(command);
            }
        }
    }

    private boolean checkLine(String text) {
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

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < menu.commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(menu.commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void addCreature() {
        Gender gender;
        System.out.println("Введите имя существа");
        String name = scanner.nextLine();
        gender = choiceGender();
        LocalDate birth = setBirthDate();
        System.out.println("Существо мертво? Да/Нет");
        String answer = scanner.nextLine();
        while (!checkQuestionIsDeath(answer)) {
            System.out.println(NEW_ATTEMPT_MESSAGE);
            answer = scanner.nextLine();
        }
        if (checkIsDeath(answer)) {
            LocalDate death = setDeathDate(birth);
            presenter.addCreature(name, birth, death, gender);
        } else {
            presenter.addCreature(name, birth, gender);
        }
    }

    private boolean checkChoiceGender(String choice) {
        if (choice != null && (choice.equalsIgnoreCase("Мужской") || choice.equalsIgnoreCase("Женский"))) {
            return true;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return false;
    }

    private Gender choiceGender() {
        System.out.println("Введите пол существа: Мужской/Женский");
        String genderChoice = scanner.nextLine();
        while (!checkChoiceGender(genderChoice)) {
            System.out.println("Введите пол существа: Мужской/Женский");
            genderChoice = scanner.nextLine();
        }
        Gender gender = null;
        if (genderChoice.equalsIgnoreCase("Мужской")) {
            gender = Gender.Male;
        } else if (genderChoice.equalsIgnoreCase("Женский")) {
            gender = Gender.Female;
        }
        return gender;
    }

    private boolean checkQuestionIsDeath(String answer) {
        if (answer != null && (answer.equalsIgnoreCase("Да") || answer.equalsIgnoreCase("Нет"))) {
            return true;
        }
        return false;
    }

    private boolean checkIsDeath(String answer) {
        return answer != null && answer.equalsIgnoreCase("Да");
    }

    private LocalDate setDeathDate(LocalDate birth) {
        LocalDate death = null;
        String deathDay = "1";
        String deathMonth = "1";
        String deathYear = "1";
        while (!checkDate(death, birth) && checkDate(LocalDate.now(), death)) {
            while (!checkInt(deathDay)) {
                System.out.println("Введите день смерти существа");
                deathDay = scanner.nextLine();
            }
            while (!checkInt(deathMonth)) {
                System.out.println("Введите месяц смерти существа");
                deathMonth = scanner.nextLine();
            }

            while (!checkInt(deathYear)) {
                System.out.println("Введите год смерти существа");
                deathYear = scanner.nextLine();
            }
            death = LocalDate.of(Integer.parseInt(deathYear), Integer.parseInt(deathMonth), Integer.parseInt(deathDay));
        }
        return death;
    }

    private boolean checkInt(String text) {
        if (text != null && text.matches("\\d+")) {
            return true;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return false;
    }

    private boolean checkDate(LocalDate firstDate, LocalDate secondDate) {
        if (firstDate != null && secondDate != null && firstDate.isAfter(secondDate)) {
            return true;
        } else {
            return false;
        }
    }

    private LocalDate setBirthDate() {
        LocalDate birth = null;
        String birthDay = null;
        String birthMonth = null;
        String birthYear = null;
        while (birth == null && !checkDate(LocalDate.now(), birth)) {
            while (!checkInt(birthDay)) {
                System.out.println("Введите день рождения существа");
                birthDay = scanner.nextLine();
            }
            while (!checkInt(birthMonth)) {
                System.out.println("Введите месяц рождения существа");
                birthMonth = scanner.nextLine();
            }
            while (!checkInt(birthYear)) {
                System.out.println("Введите год рождения существа");
                birthYear = scanner.nextLine();
            }
            birth = LocalDate.of(Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay));
        }
        return birth;
    }

    public void printFamilyTree() {
        presenter.printFamilyTree();
    }

    public void printMother(Human human) {
        presenter.printMother(human);
    }

    public void printFather(Human human) {
        presenter.printFather(human);
    }

    public void printChildren(Human human) {
        presenter.printChildren(human);
    }

    public void getInfo(Human human) {
        presenter.getInfo(human);
    }

    public void getSister(Human human) {
        presenter.getSisters(human);
    }

    public void getBrothers(Human human) {
        presenter.getBrothers(human);
    }

    public void getInteractionWithCreature(Human human) {
        SecondMenu secondMenu = new SecondMenu(this);
        while (true) {
            System.out.println(secondMenu.SecondMenu());
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= secondMenu.getSize()) {
                secondMenu.execute(choice);
            } else {
                System.out.println(NEW_ATTEMPT_MESSAGE);
            }
        }
    }
}