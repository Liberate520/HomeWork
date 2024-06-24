package View;

import Model.Human.Gender;
import Model.Human.Human;
import PresenterF.Presenter;


import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements IView, CheckMethods {
    private final Scanner scanner;
    private final Presenter presenter;
    private boolean work;
    private boolean workSec;
    private final MainMenu MENU;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        workSec = true;
        MENU = new MainMenu(this);
    }


    @Override
    public void start() throws IOException, ClassNotFoundException {
        IView.hello();
        recoverObjectFromFile();
        while (work) {
            printMenu();
            execute();
        }
    }


    public void finish() {
        try {
            writeObjectToFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        IView.bye();
        work = false;
    }

    public void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (CheckMethods.checkLine(line)) {
            int command = Integer.parseInt(line);
            if (CheckMethods.checkCommand(MENU, command)) {
                MENU.execute(command);
            }
        }
    }








    public void printMenu() {
        System.out.println(MENU.menu());
    }


    public void addCreature() {
        String name = setName();
        Gender gender = setGender();
        LocalDate birth = setBirthDate();
        String answer;
        do{
            System.out.println("Существо мертво: Да/Нет");
            answer = scanner.nextLine();
        }while (!CheckMethods.checkQuestionIsDeath(answer));
        if(answer.equals("Да")){
            presenter.addCreature(name, birth, setDeathDate(birth), gender);
        }
        else {
            presenter.addCreature(name, birth, gender);
        }
    }


    public String setName(){
        String name;
        do{
            System.out.println("Введите имя существа");
            name = scanner.nextLine();
        }while (CheckMethods.checkEmptyString(name));
        return name;
    }

    public Gender setGender(){
        String choiceGender;
        do{
            System.out.println("Введите пол существа: Мужской/Женский");
            choiceGender = scanner.nextLine();
        }while(!CheckMethods.checkChoiceGender(choiceGender));
        if (choiceGender.equals("Мужской"))
            return Gender.Male;
        return Gender.Female;
    }

    public LocalDate setBirthDate() {
        LocalDate birth;
        String day;
        String month;
        String year;
        do {
            do {
                do {
                    System.out.println("Введите день рождения человека");
                    day = scanner.nextLine();
                } while (CheckMethods.checkInt(day));
                do {
                    System.out.println("Введите месяц рождения человека");
                    month = scanner.nextLine();
                } while (CheckMethods.checkInt(month));
                do {
                    System.out.println("Введите год рождения человека");
                    year = scanner.nextLine();
                } while (CheckMethods.checkInt(year));

            } while (!CheckMethods.checkFullDate(year, month, day));
            birth = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } while (CheckMethods.checkDate(LocalDate.now(), birth));
        return birth;
    }

    public LocalDate setDeathDate(LocalDate birthDate){
        LocalDate deathDate;
        String day;
        String month;
        String year;
        do {
        do {
            System.out.println(1);
            do {
                System.out.println(2);
                do {
                    System.out.println("Введите день смерти человека");
                    day = scanner.nextLine();
                } while (CheckMethods.checkInt(day));
                do {
                    System.out.println("Введите месяц смерти человека");
                    month = scanner.nextLine();
                } while (CheckMethods.checkInt(month));
                do {
                    System.out.println("Введите год смерти человека");
                    year = scanner.nextLine();
                } while (CheckMethods.checkInt(year));

            } while (!CheckMethods.checkFullDate(year, month, day));
            deathDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
        } while (CheckMethods.checkDate(deathDate, birthDate));
        }while (CheckMethods.checkDate(LocalDate.now(), deathDate)); //We are up to that the current date follows once the birthdate
        // from the setBirthDate where checking is executed
        return deathDate;
    }







//    private Gender choiceGender() {
//        System.out.println("Введите пол существа: Мужской/Женский");
//        String genderChoice = scanner.nextLine();
//        while (!CheckMethods.checkChoiceGender(genderChoice)) {
//            System.out.println("Введите пол существа: Мужской/Женский");
//            genderChoice = scanner.nextLine();
//        }
//        Gender gender = null;
//        if (genderChoice.equalsIgnoreCase("Мужской")) {
//            gender = Gender.Male;
//        } else if (genderChoice.equalsIgnoreCase("Женский")) {
//            gender = Gender.Female;
//        }
//        return gender;
//    }










    public void printFamilyTree() {
        IView.printAnswer(presenter.printFamilyTree());
    }


    public void getInfo() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID человека о котором хотите всё узнать");
            id = scanner.nextLine();
        }while (checkId(id));
        Human human = getCreatureById(id);
        IView.printAnswer(human.getInfo());
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

    public boolean checkId(String id){
        if ((Integer.parseInt(id) >= 0) & (presenter.getFamilyTreeSize() > Integer.parseInt(id))){
            return false;
        }
        System.out.println(NEW_ATTEMPT_MESSAGE);
        return true;

    }

    public Human getCreatureById(String id){
        return presenter.getCreatureById(id);
    }

    public void addMother(){
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID ребёнка");
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        printFamilyTree();
        do{
            System.out.println("Введите ID матери");
            id = scanner.nextLine();
        }while (checkId(id));
        Human mother = getCreatureById(id);
        presenter.addMother(child, mother);
    }

    public void addFather(){
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID ребёнка");
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        printFamilyTree();
        do{
            System.out.println("Введите ID отца");
            id = scanner.nextLine();
        }while (checkId(id));
        Human mother = getCreatureById(id);
        presenter.addFather(child, mother);
    }

    public void removeMother() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID ребёнка у которого хотите убрать мать"); //Не устранить!!!!
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        if(child.getFather() != null)
            presenter.removeMother(child);
        else
            System.out.println("У ребёнка и так нету матери");
    }

    public void removeFather() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID ребёнка у которого хотите убрать отца"); //Не устранить!!!!
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        if(child.getFather() != null)
            presenter.removeFather(child);
        else
            System.out.println("У ребёнка и так нету отца");
    }

    public void addChild() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID родителя");
            id = scanner.nextLine();
        }while (checkId(id));
        Human parent = getCreatureById(id);
        do{
            System.out.println("Введите ID ребёнка");
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        presenter.addChild(parent, child);
    }

    public void removeChild() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID ребёнка");
            id = scanner.nextLine();
        }while (checkId(id));
        Human child = getCreatureById(id);
        do{
            System.out.println("Введите ID родителя");
            id = scanner.nextLine();
        }while (checkId(id));
        Human parent = getCreatureById(id);
        presenter.removeChild(parent, child);
    }

    public void setSpouse() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID первого члена брака");
            id = scanner.nextLine();
        }while (checkId(id));
        Human human1 = getCreatureById(id);
        do{
            System.out.println("Введите ID второго члена брака");
            id = scanner.nextLine();
        }while (checkId(id));
        Human human2 = getCreatureById(id);
        presenter.setSpouse(human1, human2);
    }

    public void setDivorce() {
        printFamilyTree();
        String id;
        do{
            System.out.println("Введите ID члена брака");
            id = scanner.nextLine();
        }while (checkId(id));
        Human human = getCreatureById(id);
        presenter.setDivorce(human);
    }

    public void writeObjectToFile() throws IOException {
        presenter.writeObjectToFile();

    }

    public void recoverObjectFromFile() throws IOException, ClassNotFoundException{
        presenter.recoverObjectFromFile();
    }




}