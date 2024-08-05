package View;

import Model.Human.Gender;
import Presenter.Presenter;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI implements View{

    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    private boolean work;
    private Gender gender;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        work = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        greeting();
        while(work){
            printMenu();
            workWithFamilyTree();
        }
    }

    public void addHuman(){
        System.out.println("Введите имя человека:");
        String name = scanner.nextLine();
        gender = addHumanGender();
        LocalDate birthDate = addHumanBirthdate();
        LocalDate deathDate = addHumanDeathdate(birthDate);
        presenter.addHuman(name, gender, birthDate, deathDate);
    }

    public void addRelations() {
        boolean flag = true;
        int choice = 0;
        int ID = 0;
        int humanID = 0;
        System.out.println("Введите ID человека:");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            humanID = Integer.parseInt(str);
        }
        else {
            flag = false;
        }
        while (flag){
            System.out.println("Желаете добавить родственные связи с уже добавленными людьми?\n" +
                    "1. Добавить супруга/супругу.\n" +
                    "2. Удалить супруга/супругу.\n" +
                    "3. Добавить родителя (мать, отца).\n" +
                    "4. Добавить ребенка.\n" +
                    "0. Закончить выбор.\n");
            try {
                str = scanner.nextLine();
                if (checkTextForInt(str)) {
                    choice = Integer.parseInt(str);
                }
                switch (choice){
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        System.out.println("Введите ID супруга/супруги");
                        str = scanner.nextLine();
                        if (checkTextForInt(str)) {
                            ID = Integer.parseInt(str);
                            addSpouse(humanID, ID);
                        }
                        else {
                            flag = false;
                        }

                        break;
                    case 2:
                        deleteSpouse(humanID);
                        System.out.println("Информация о супругах удалена");
                        break;
                    case 3:
                        System.out.println("Введите ID родителя");
                        str = scanner.nextLine();
                        if (checkTextForInt(str)) {
                            ID = Integer.parseInt(str);
                            addParent(humanID, ID);
                        }
                        else {
                            flag = false;
                        }
                        break;
                    case 4:
                        System.out.println("Введите ID ребенка");
                        str = scanner.nextLine();
                        if (checkTextForInt(str)) {
                            ID = Integer.parseInt(str);
                            addChild(humanID, ID);
                        }
                        else {
                            flag = false;
                        }
                        break;
                    default:
                        System.out.println("Ошибка. Неверные данные.");
                        break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Ошибка. Неверные данные.");
            }
        }
    }

    private Gender addHumanGender() {
        System.out.println("Введите пол человека (М/Ж или M/F):");
        String genderStr = scanner.nextLine();
        if (genderStr.equalsIgnoreCase("м") || genderStr.equalsIgnoreCase("m")) {
            gender = Gender.Male;
        }
        else if (genderStr.equalsIgnoreCase("ж") || genderStr.equalsIgnoreCase("f")) {
            gender = Gender.Female;
        }
        else {
            System.out.println("Ошибка пола");//TODO
            return null;
        }
        return gender;
    }

    private LocalDate addHumanBirthdate() {
        System.out.println("Введите дату рождения человека (ГГГГ-ММ-ДД):");
        String dateStr = scanner.nextLine();
        if(checkDateFormat(dateStr)) {
            LocalDate birthDate = LocalDate.parse(dateStr);
            return birthDate;
        }
        return null;
    }

    private LocalDate addHumanDeathdate(LocalDate birthDate) {
        System.out.println("Введите дату смерти человека (при наличии, ГГГГ-ММ-ДД). При отсутствии введите любой символ.");
        String dateStr = scanner.nextLine();
        if(checkDateFormat(dateStr)) {
            LocalDate deathDate = LocalDate.parse(dateStr);
            if (deathDate.isAfter(birthDate)){
                return deathDate;
            }
            System.out.println("Ошибка. Дата смерти должна идти раньше даты рождения.");
        }
        return null;
    }

    boolean checkDateFormat(String str){
        try{
            LocalDate.parse(str);
        }
        catch (DateTimeParseException e){
            System.out.println("Ошибка. Неверный формат даты");
            return false;
        }
        return true;
    }

    public void addSpouse(int humanID, int spouseID){
        presenter.addSpouse(humanID, spouseID);
    }

    public void deleteSpouse(int humanID){
        presenter.deleteSpouse(humanID);
    }

    public void addParent(int humanID, int parentID){
        presenter.addParent(humanID, parentID);
    }

    public void addChild(int humanID, int childID){
        presenter.addChild(humanID, childID);
    }

    public void deleteHuman(){
        System.out.println("Введите ID человека, которого требуется удалить из семейного дерева:");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            int ID = Integer.parseInt(str);
            presenter.deleteHuman(ID);
        }
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByAge(){
        presenter.sortByAge();
    }

    public void sortByBirthdate(){
        presenter.sortByBirthdate();
    }

    public void sortByChildrenNumber(){
        presenter.sortByChildrenNumber();
    }

    public void showFamilyTreeInfo(){
        presenter.showFamilyTreeInfo();
    }

    public void saveToFile() throws IOException {
        System.out.println("Введите название файла для записи (при отсутствии будет использовано название по умолчанию):");
        String filename = scanner.nextLine();
        if (filename.isEmpty()) {
            filename = "FamilyTree_ver_1.0.ser";
        }
        presenter.saveToFile(filename);
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        System.out.println("Введите название файла для чтения (при отсутствии будет использовано название по умолчанию):");
        String filename = scanner.nextLine();
        if (filename.isEmpty()) {
            filename = "FamilyTree_ver_1.0.ser";
        }
        presenter.loadFromFile(filename);
    }

    public void finishWork() {
        System.out.println("Работа с семейным деревом завершена.\n" +
                "До новых встреч!");
        work = false;
    }

    private void workWithFamilyTree() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private void printMenu() {
        System.out.println(mainMenu.menu());
    }

    private void greeting() {
        System.out.println("Добро пожаловать!\n" +
                "Начинаем работу с семейным деревом.");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
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
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println("Вы ввели неверное значение");
    }
}
