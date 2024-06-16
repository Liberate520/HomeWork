package View;

import Model.Human.Gender;
import Model.Human.Human;
import PresenterF.Presenter;


import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements IView, CheckMethods {
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private final MainMenu MENU;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        MENU = new MainMenu(this);
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
        if (CheckMethods.checkLine(line)) {
            int command = Integer.parseInt(line);
            if (CheckMethods.checkCommand(MENU, command)) {
                MENU.execute(command);
            }
        }
    }





//    public String MENU() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int i = 0; i < MENU.commandList.size(); i++) {
//            stringBuilder.append(i + 1);
//            stringBuilder.append(". ");
//            stringBuilder.append(MENU.commandList.get(i).getDescription());
//            stringBuilder.append("\n");
//        }
//        return stringBuilder.toString();
//    }

    private void printMenu() {
        System.out.println(MENU.menu());
    }


    public void addCreature() {
        Gender gender;
        String name = "";
        while(checkEmptyString(name)){
            System.out.println("Введите имя существа");
            name = scanner.nextLine();
        }
        gender = choiceGender();
        LocalDate birth = setBirthDate();
        System.out.println("Существо мертво? Да/Нет");
        String answer = scanner.nextLine();
        while (!CheckMethods.checkQuestionIsDeath(answer)) {
            System.out.println(NEW_ATTEMPT_MESSAGE);
            answer = scanner.nextLine();
        }
        if (CheckMethods.checkIsDeath(answer)) {
            LocalDate death = setDeathDate(birth);
            presenter.addCreature(name, birth, death, gender);
        } else {
            presenter.addCreature(name, birth, gender);
        }
    }

    private boolean checkEmptyString (String name){
        if (!name.isEmpty()) {
            System.out.println(INPUT_ERROR);
            return true;
        }
        else {
            return false;
        }

    }



    private Gender choiceGender() {
        System.out.println("Введите пол существа: Мужской/Женский");
        String genderChoice = scanner.nextLine();
        while (!CheckMethods.checkChoiceGender(genderChoice)) {
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




    private LocalDate setDeathDate(LocalDate birth) {
        LocalDate death = null;
        String deathDay = "";
        String deathMonth = "";
        String deathYear = "";
        while (!CheckMethods.checkDate(death, birth) && CheckMethods.checkDate(LocalDate.now(), death)) {
            while (!CheckMethods.checkInt(deathDay)) {
                System.out.println("Введите день смерти существа");
                deathDay = scanner.nextLine();
            }
            while (!CheckMethods.checkInt(deathMonth)) {
                System.out.println("Введите месяц смерти существа");
                deathMonth = scanner.nextLine();
            }

            while (!CheckMethods.checkInt(deathYear)) {
                System.out.println("Введите год смерти существа");
                deathYear = scanner.nextLine();
            }
            death = LocalDate.of(Integer.parseInt(deathYear), Integer.parseInt(deathMonth), Integer.parseInt(deathDay));
        }
        return death;
    }



    private LocalDate setBirthDate() {
        LocalDate birth = null;
        String birthDay = null;
        String birthMonth = null;
        String birthYear = null;
        while (((birth == null) || (!CheckMethods.checkDate(LocalDate.now(), birth)))) {
            while (!CheckMethods.checkInt(birthDay)) {
                System.out.println("Введите день рождения существа");
                birthDay = scanner.nextLine();
            }
            while (!CheckMethods.checkInt(birthMonth)) {
                System.out.println("Введите месяц рождения существа");
                birthMonth = scanner.nextLine();
            }
            while (!CheckMethods.checkInt(birthYear)) {
                System.out.println("Введите год рождения существа");
                birthYear = scanner.nextLine();
            }
            birth = LocalDate.of(Integer.parseInt(birthYear), Integer.parseInt(birthMonth), Integer.parseInt(birthDay));
        } //Проверки на null реализуются в методе CheckMethods.checkInt в строках 168, 172, 176
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

    public void getSisters(Human human) {
        presenter.getSisters(human);
    }

    public void getBrothers(Human human) {
        presenter.getBrothers(human);
    }

    public void getInteractionWithCreature(Human human) { // Реализуется в будущем
        SecondMenu secondMenu = new SecondMenu(this);
        while (true) { //Необходимость в постоянной работе цикла
            System.out.println(secondMenu.printSecondMenu());
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice > 0 && choice <= secondMenu.getSize()) {
                secondMenu.execute(choice);
            } else {
                System.out.println(NEW_ATTEMPT_MESSAGE);
            }
        }
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByCountChildren(){
        presenter.sortByCountOfChildren();
    }



}