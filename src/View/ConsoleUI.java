package View;

import Model.Human.Gender;
import Presenter.Presenter;
import View.Commands.MainMenu;
import View.RelationsMenu.RelationsMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private MainMenu mainMenu;
    private RelationsMenu relationsMenu;
    private Output output;
    private boolean work;
    private boolean flag;
    private Gender gender;
    private String defaultFilename = "FamilyTree_ver_1.0.ser";

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        relationsMenu = new RelationsMenu(this);
        output = new Output();
        work = true;
        flag = true;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        output.printGreetingMessage();
        while(work){
            printMenu();
            workWithFamilyTree();
        }
    }

    public void addHuman(){
        output.printMessage("Введите имя человека:");
        String name = scanner.nextLine();
        gender = addHumanGender();
        LocalDate birthDate = addHumanBirthdate();
        LocalDate deathDate = addHumanDeathdate(birthDate);
        presenter.addHuman(name, gender, birthDate, deathDate);
    }

    public void addRelations(){
        int humanID = 0;
        flag = true;
        output.printMessage("Введите ID человека:");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            humanID = Integer.parseInt(str);
        }
        else {
            flag = false;
        }
        while (flag){
            System.out.println(relationsMenu.RelationsMenuDescription());
            changeRelations(humanID);
        }
    }

     private void changeRelations(int humanID){
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            int choice = Integer.parseInt(str);
            if (choice <= relationsMenu.getListSize()){
                relationsMenu.execute(choice, humanID);
            }
        }
        else {
            output.printErrorMessage();;
        }
    }

    public void addSpouseMenu(int humanID){
        output.printMessage("Введите ID супруга/супруги");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            int ID = Integer.parseInt(str);
            addSpouse(humanID, ID);
        }
    }

    public void deleteSpouseMenu(int humanID){
        deleteSpouse(humanID);
    }

    public void addParentMenu(int humanID){
        output.printMessage("Введите ID родителя");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            int ID = Integer.parseInt(str);
            addParent(humanID, ID);
        }
    }

    public void addChildMenu(int humanID){
        output.printMessage("Введите ID ребенка");
        String str = scanner.nextLine();
        if (checkTextForInt(str)) {
            int ID = Integer.parseInt(str);
            addChild(humanID, ID);
        }
    }

    public void finishRelationsChoice(){
        flag = false;
    }

    private Gender addHumanGender() {
        output.printMessage("Введите пол человека (М/Ж или M/F):");
        String genderStr = scanner.nextLine();
        if (genderStr.equalsIgnoreCase("м") || genderStr.equalsIgnoreCase("m")) {
            gender = Gender.Male;
        }
        else if (genderStr.equalsIgnoreCase("ж") || genderStr.equalsIgnoreCase("f")) {
            gender = Gender.Female;
        }
        else {
            output.printGenderError();
            return null;
        }
        return gender;
    }

    private LocalDate addHumanBirthdate() {
        output.printMessage("Введите дату рождения человека (ГГГГ-ММ-ДД):");
        String dateStr = scanner.nextLine();
        if(checkDateFormat(dateStr)) {
            LocalDate birthDate = LocalDate.parse(dateStr);
            return birthDate;
        }
        return null;
    }

    private LocalDate addHumanDeathdate(LocalDate birthDate) {
        output.printMessage("Введите дату смерти человека (при наличии, ГГГГ-ММ-ДД). При отсутствии введите любой символ.");
        String dateStr = scanner.nextLine();
        if(checkDateFormat(dateStr)) {
            LocalDate deathDate = LocalDate.parse(dateStr);
            if (deathDate.isAfter(birthDate)){
                return deathDate;
            }
            output.printDateError();
        }
        return null;
    }

    boolean checkDateFormat(String str){
        try{
            LocalDate.parse(str);
        }
        catch (DateTimeParseException e){
            output.printDateFormatError();
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
        output.printMessage("Введите ID человека, которого требуется удалить из семейного дерева:");
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
        output.printMessage("Введите название файла для записи (при отсутствии будет использовано название по умолчанию):");
        String filename = scanner.nextLine();
        if (filename.isEmpty()) {
            filename = defaultFilename;
        }
        presenter.saveToFile(filename);
    }

    public void loadFromFile() throws IOException, ClassNotFoundException {
        output.printMessage("Введите название файла для чтения (при отсутствии будет использовано название по умолчанию):");
        String filename = scanner.nextLine();
        if (filename.isEmpty()) {
            filename = defaultFilename;
        }
        presenter.loadFromFile(filename);
    }

    public void finishWork() {
        output.printExitMessage();
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
        output.printMessage(mainMenu.menu());
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);//TODO
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            output.printErrorMessage();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.getSize()){
            return true;
        } else {
            output.printErrorMessage();
            return false;
        }
    }
}
