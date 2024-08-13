package View;

import Model.Creature.Info;
import Model.Creature.OwnInfo;
import Model.Formating.Check;
import Model.Formating.Exceptions.Gender_ERROR;
import Model.Formating.MyDate;
import View.Exceptions.InputERROR;
import Presenter.Presenter;
import View.Commands.Command;
import View.Exceptions.CommandERROR;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI implements View {
    private final Scanner scanner = new Scanner(System.in);
    private String consoleName;
    private Presenter presenter;
    private boolean runApp;

    private final String prefix = "\t";
    private final String additionalPrefix = "\t";
    private final String NULL = "null";

    private final CommandsList commandsList;
    private ArrayList<Command> commands;

    public ConsoleUI(){
        this.commandsList = new CommandsList(this);
        this.commands = new ArrayList<>();
        this.runApp = true;

        toDatabaseConsole();
    }

    private void toDatabaseConsole(){
        this.consoleName = "Database";
        this.commands = this.commandsList.getDatabaseCommands();
    }

    private void toFamilyTreeConsole(){
        this.consoleName = "Family tree";
        this.commands = this.commandsList.getFamilyTreeCommands();
    }

    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }


    public void mainLoop(){
        while (this.runApp){
            String userInput = askCommand();

            if (userInput.isEmpty())
                printERROR(new InputERROR("Console cant be empty"));

            else execute(userInput);
        }
    }

    private void execute(String commandName){
        boolean isExist = false;

        for (Command command: this.commands){
            if (command.getKey().equals(commandName)){
                command.execute();

                isExist = true;
            }
        }

        if(!isExist){
            printERROR(new CommandERROR());
        }
    }

    public void exit(){
        this.runApp = false;
    }
    
    private void printSuccessful(){
        printResult("Successful");
    }

    private void printResult(String message) {
        printMessage("Result", message);
    }

    private void printMessage(String signature, String message){
        System.out.printf("%s%s: %s\n", this.prefix, signature, message);
    }

    private void printERROR(Exception exception) {
        System.out.printf("%s%s: %s\n", prefix, exception.getClass().getSimpleName(), exception.getMessage());
    }

    private void nextLine(){
        System.out.println();
    }

    private String askCommand(){
        System.out.printf("\n%s: ", this.consoleName);
        String userInput = this.scanner.nextLine();

        nextLine();

        return userInput;
    }

    private String ask(String question){
         System.out.printf("%s%s: ", this.prefix, question);
         String userInput = this.scanner.nextLine();

         nextLine();

         return userInput;
    }

    private void printField(String additionalPrefix, String field, Object value){
        if (value != null)
            System.out.printf("%s%s%s: %s\n", this.prefix, additionalPrefix, field, value);
    }

    private void printField(String field, Object value){
        printField("", field, value);
    }

    private void printOwnInfo(String additionalPrefix, OwnInfo ownInfo){
        printField(additionalPrefix, "ID", ownInfo.getID());
        printField(additionalPrefix, "Name", ownInfo.getName());
        printField(additionalPrefix, "Surname", ownInfo.getSurname());
        printField(additionalPrefix, "Gender", ownInfo.getGender());
        printField(additionalPrefix, "Data of birth", ownInfo.getDateOfBirth());
        printField(additionalPrefix, "Data of death", ownInfo.getDateOfDeath());
    }

    private void printOwnInfo(OwnInfo ownInfo){
        printOwnInfo("", ownInfo);
    }

    private void printAnotherEntityInfo(String entity, OwnInfo ownInfo){
        if(ownInfo != null){
            System.out.printf("%s%s: ", this.prefix, entity);
            nextLine();
            printOwnInfo(this.additionalPrefix, ownInfo);
        }
    }

    public void createFamilyTree() {
        String familyTreeName = ask("File name");
        String description = ask("Description");

        this.presenter.createFamilyTree(familyTreeName, description);

        toFamilyTreeConsole();

        printSuccessful();
    }

    public void exitFromFamilyTree(){
        this.presenter.exitFromFamilyTree();
        toDatabaseConsole();
    }

    private void printInfo(Info info){
        printOwnInfo(info.getSelfInfo());
        printAnotherEntityInfo("Spouse", info.getSpouseInfo());
        printAnotherEntityInfo("Mather", info.getMatherInfo());
        printAnotherEntityInfo("Father", info.getFatherInfo());

        if(info.getChildrenInfo() != null){
            System.out.printf("%sChildren: ", this.prefix);
            nextLine();

            for (OwnInfo kidOwnInfo : info.getChildrenInfo().subList(0, info.getChildrenInfo().size() - 1)){
                printOwnInfo(this.additionalPrefix, kidOwnInfo);
                nextLine();
            }
            printOwnInfo(this.additionalPrefix, info.getChildrenInfo().getLast());
        }
    }

    private void printInfos(ArrayList<Info> infos){
        for (Info Owninfo : infos.subList(0, infos.size() - 1)){
            printInfo(Owninfo);
            nextLine();
        }
        printInfo(infos.getLast());
    }

    public void printFamilyTree() {
        ArrayList<Info> infos = this.presenter.getFamilyTreeInfo();

        if (infos.isEmpty()){
            printResult("FamilyTree is empty");
            return;
        }

        printInfos(infos);
    }

    public void addEntity(){
        String name = ask("Name");
        String surname = ask("Surname");
        String inputGender = ask("Gender");

        if (name.equalsIgnoreCase(NULL))
            name = null;

        if (surname.equalsIgnoreCase(NULL))
            surname = null;

        if (!Check.isGender(inputGender))
            printERROR(new Gender_ERROR());

        else {
            this.presenter.addEntity(name, surname, Check.parseGender(inputGender));

            printSuccessful();
        }
    }

    public void printCommands(){
        for (Command command: this.commands.subList(0, this.commands.size() - 1)){
            printField("Key", command.getKey());
            printField("Description", command.getDescription());
            nextLine();
        }
        printField("Key", this.commands.getLast().getKey());
        printField("Description", this.commands.getLast().getDescription());
    }

    public void findEntity(){
        String name = ask("Name");
        String surname = ask("Surname");

        ArrayList<Info> infos = this.presenter.findEntity(name, surname);

        if (infos.isEmpty()){
            printResult("Not found");
            return;
        }

        printInfos(infos);
    }

    public void printEntity(){
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        try {
            printInfo(this.presenter.getEntityInfo(Integer.parseInt(inputID)));

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void removeEntity(){
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.removeEntity(Integer.parseInt(inputID));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }


    public void setEntityName() {
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        String newName = ask("New name");

        if (newName.equalsIgnoreCase(NULL))
            newName = null;

        try {
            this.presenter.changeEntityName(Integer.parseInt(inputID), newName);

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setEntitySurname() {
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        String newSurname = ask("New surname");

        if (newSurname.equalsIgnoreCase(NULL))
            newSurname = null;

        try {
            this.presenter.changeEntitySurname(Integer.parseInt(inputID), newSurname);

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setEntitySpouse(){
        String ID = ask("ID");

        if (!Check.isInt(ID)){
            printERROR(new InputERROR());
            return;
        }

        String spouseID = ask("Spouse ID");

        if (!Check.isInt(spouseID)){
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.changeEntitySpouse(Integer.parseInt(ID), Integer.parseInt(spouseID));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setEntityMather(){
        String ID = ask("ID");

        if (!Check.isInt(ID)){
            printERROR(new InputERROR());
            return;
        }

        String matherID = ask("Mather ID");

        if (!Check.isInt(matherID)) {
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.changeEntityMather(Integer.parseInt(ID), Integer.parseInt(matherID));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setEntityFather(){
        String ID = ask("ID");

        if (!Check.isInt(ID)){
            printERROR(new InputERROR());
            return;
        }

        String matherID = ask("Father ID");

        if (!Check.isInt(matherID)) {
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.changeEntityFather(Integer.parseInt(ID), Integer.parseInt(matherID));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void addKid(){
        String ID = ask("ID");

        if (!Check.isInt(ID)) {
            printERROR(new InputERROR());
            return;
        }

        String kidID = ask("Kid ID");

        if (!Check.isInt(kidID)){
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.addKid(Integer.parseInt(ID), Integer.parseInt(kidID));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }


    public void sortByChildren() {
        this.presenter.sortByChildren();

        printSuccessful();
    }

    public void sortByName() {
        this.presenter.sortByName();

        printSuccessful();
    }

    public void sortBySurname(){
        this.presenter.sortBySurname();

        printSuccessful();
    }

    public void sortByID(){
        this.presenter.sortByID();

        printSuccessful();
    }

    public void setDateOfBirth() {
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        String day = ask("Day");

        if (!Check.isInt(day)){
            printERROR(new InputERROR());
            return;
        }

        String month = ask("Month");

        if (!Check.isInt(month)){
            printERROR(new InputERROR());
            return;
        }

        String year = ask("Year");

        if (!Check.isInt(year)){
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.changeDataOfBirth(
                    Integer.parseInt(inputID),
                    Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(day)
            );

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setDataOfDeath() {
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        String day = ask("Day");

        if (!Check.isInt(day)){
            printERROR(new InputERROR());
            return;
        }

        String month = ask("Month");

        if (!Check.isInt(month)){
            printERROR(new InputERROR());
            return;
        }

        String year = ask("Year");

        if (!Check.isInt(year)){
            printERROR(new InputERROR());
            return;
        }

        try {
            this.presenter.changeDataOfDeath(
                    Integer.parseInt(inputID),
                    Integer.parseInt(year),
                    Integer.parseInt(month),
                    Integer.parseInt(day)
            );

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setGender() {
        String inputID = ask("ID");

        if (!Check.isInt(inputID)){
            printERROR(new InputERROR());
            return;
        }

        String inputGender = ask("New Gender");

        if (inputGender.equals(NULL)){
            inputGender = null;
        }

        else if (!Check.isGender(inputGender)){
            printERROR(new Gender_ERROR());
            return;
        }

        try {
            this.presenter.changeEntityGender(Integer.parseInt(inputID), Check.parseGender(inputGender));

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void saveTree(){
        try {
            this.presenter.saveFamilyTree();

            printSuccessful();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void setFileName(){
        String newFileName = ask("New file name");

        this.presenter.changeFileName(newFileName);

        printSuccessful();
    }

    public void setDescription(){
        String newDescription = ask("New description");

        this.presenter.changeDescription(newDescription);

        printSuccessful();
    }

    public void openSave() {
        String fileName = ask("File name");

        try {
            this.presenter.openSave(fileName);

            toFamilyTreeConsole();

        } catch (Exception exception){
            printERROR(exception);
        }
    }

    public void printSaves() {
        ArrayList<String> list = this.presenter.getSavesList();

        if (list.isEmpty()){
            printResult("Database is empty");
            return;
        }

        for (String saveName: list){
            System.out.println(this.prefix + saveName);
        }
    }

    public void printDescription() {
        String description = this.presenter.getSaveDescription();

        if (description.isEmpty()){
            printResult("Description is empty");
            return;
        }

        System.out.println(prefix + description);
    }

    public void printFilename() {
        System.out.println(this.prefix + this.presenter.getFileName());
    }
}
