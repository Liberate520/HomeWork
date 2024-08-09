package ru.gb.family_tree.view.console_ui;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.writer.Writer;
import ru.gb.family_tree.presenter.Presenter;
import ru.gb.family_tree.view.Ui;
import ru.gb.family_tree.view.console_ui.enums.LocalDatesTypes;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.view.console_ui.menus.Menu;
import ru.gb.family_tree.view.console_ui.menus.choose_children.ChooseChildren;
import ru.gb.family_tree.view.console_ui.menus.choose_gender.ChooseGender;
import ru.gb.family_tree.view.console_ui.menus.choose_parent.ChooseParent;
import ru.gb.family_tree.view.console_ui.menus.choose_parent.Parents;
import ru.gb.family_tree.view.console_ui.menus.edit_menu.EditMenu;
import ru.gb.family_tree.view.console_ui.menus.edit_options_menu.EditOptionsMenu;
import ru.gb.family_tree.view.console_ui.menus.load_file.LoadFile;
import ru.gb.family_tree.view.console_ui.menus.main_menu.MainMenu;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleUi implements Ui {
    private Presenter presenter;
    private Scanner scanner;
    private InfoCollector infoCollector;
    private MainMenu mainMenu;
    private ChooseParent chooseParentMenu;
    private ChooseGender chooseGenderMenu;
    private ChooseChildren chooseChildrenMenu;
    private EditMenu editMenu;
    private EditOptionsMenu editOptionsMenu;
    private LoadFile loadFileMenu;
    private boolean savedFlag;
    private List<CollectorItems> editedItems;
    private boolean stopEditFlag;

    public ConsoleUi(Writer writer) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, writer);
        infoCollector = new InfoCollector();
        mainMenu = new MainMenu(this);
        savedFlag = true;
    }

    public void setInfoInCollector(Object data, CollectorItems collectorItem) {
        infoCollector.setCollectorItem(data, collectorItem);
        editedItems.add(collectorItem);
    }

    public void initNewCollector(){
        infoCollector = new InfoCollector();
        editedItems = new ArrayList<>();
    }

    public Object getInfoFromCollector(CollectorItems collectorItem){
        return infoCollector.getCollectorItem(collectorItem);
    }

    @Override
    public void startUi() {
        mainMenu();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
        System.out.println("Для возврата в главное меню нажмите Enter...");
        scanner.nextLine();
        mainMenu();
    }

    public void initInputDataAddHuman(){
        initNewCollector();
        infoCollector.setCollectorItem((Object)inputName(), CollectorItems.Name);
        infoCollector.setCollectorItem((Object)inputPatronymic(), CollectorItems.Patronymic);
        infoCollector.setCollectorItem((Object)inputSurname(), CollectorItems.Surname);
        initChooseGenderMenu();
        if(yesNoQuestion("Указать родителей?")){
            initChooseFatherMenu();
            initChooseMotherMenu();
        }
        infoCollector.setCollectorItem((Object)inputProfession(), CollectorItems.Profession);
        infoCollector.setCollectorItem((Object)inputNationality(), CollectorItems.Nationality);
        infoCollector.setCollectorItem((Object)inputLocalDate(LocalDatesTypes.DateOfBirth), CollectorItems.DateOfBirth);
        infoCollector.setCollectorItem((Object)inputBirthPlace(), CollectorItems.BirthPlace);
        infoCollector.setCollectorItem((Object)inputLocalDate(LocalDatesTypes.DateOfDeath), CollectorItems.DateOfDeath);
        infoCollector.setCollectorItem((Object)inputNotes(), CollectorItems.Notes);
        addChildren();

        addHuman(false);
        addMore();
    }

    public void addHuman(boolean ignoreSuccessMassage){
        presenter.addHuman(ignoreSuccessMassage,
                (String)infoCollector.getCollectorItem(CollectorItems.Name),
                (String)infoCollector.getCollectorItem(CollectorItems.Patronymic),
                (String)infoCollector.getCollectorItem(CollectorItems.Surname),
                (Gender) infoCollector.getCollectorItem(CollectorItems.Gender),
                (Human)infoCollector.getCollectorItem(CollectorItems.Father),
                (Human)infoCollector.getCollectorItem(CollectorItems.Mother),
                (List<Human>)infoCollector.getCollectorItem(CollectorItems.Children),
                (String)infoCollector.getCollectorItem(CollectorItems.Profession),
                (String)infoCollector.getCollectorItem(CollectorItems.Nationality),
                (LocalDate) infoCollector.getCollectorItem(CollectorItems.DateOfBirth),
                (LocalDate)infoCollector.getCollectorItem(CollectorItems.DateOfDeath),
                (String)infoCollector.getCollectorItem(CollectorItems.BirthPlace),
                (String)infoCollector.getCollectorItem(CollectorItems.Notes)
        );
        savedFlag = false;
    }

    public void addChildren() {
        if(yesNoQuestion("Добавить детей?")){
            generateChildrenList();
        }
    }

    public void stopEdit(){
        stopEditFlag = true;
    }

    public void mainMenu(){
        MainMenu mainMenu = new MainMenu(this);
        uploadMenu(mainMenu);
    }

    public void editHuman(int id){
        if(editedItems.isEmpty()){
            System.out.println("Вы ничего не изменили в записи!");
            if (yesNoQuestion("Оставить эту запись как есть?")){
                mainMenu();
            }
        } else {
            presenter.editHuman(id, infoCollector, editedItems);
            savedFlag = false;
            stopEditFlag = true;
        }
    }

    public void initEditMenu(){
        Map<String, Integer> editMenuItems = presenter.getInfoForEdit();
        editMenu = new EditMenu(editMenuItems, this);
        uploadMenu(editMenu);
    }

    public void initEditOptions(int id){
        initNewCollector();
        editOptionsMenu = new EditOptionsMenu(this, id);
        stopEditFlag = false;
        while (!stopEditFlag){
            uploadMenu(editOptionsMenu);
        }
    }

    private void generateChildrenList(){
        boolean stopFlag = false;
        Map<String, Integer> fullNameID = presenter.getInfoForChooseChildren(
                (LocalDate) infoCollector.getCollectorItem(CollectorItems.DateOfBirth),
                (LocalDate) infoCollector.getCollectorItem(CollectorItems.DateOfDeath)
        );
        chooseChildrenMenu = new ChooseChildren(fullNameID, this);
        while(!stopFlag){
            if(chooseChildrenMenu.size() == 0){
                stopFlag = true;
                uploadMenu(chooseChildrenMenu);
            } else {
                uploadMenu(chooseChildrenMenu);
                if(!yesNoQuestion("Добавить еще?")){
                    stopFlag = true;
                }
            }
        }
    }

    private String inputBirthPlace() {
        return inputParam("место рождения");
    }

    private String inputNotes() {
        if(yesNoQuestion("Добавить примечания?")){
            return inputParam("заметки");
        }
        return null;
    }


    public boolean yesNoQuestion(String question){
        boolean stopFlag = false;
        boolean result = false;
        while (!stopFlag){
            System.out.println(question + " Y/N?");
            String answer = scanner.nextLine();
            switch (answer.toLowerCase()){
                case "y" -> {
                    stopFlag = true;
                    result = true;
                }
                case "n" -> {
                    stopFlag = true;
                }
                default -> {
                    System.out.println("Неверный ввод!");
                }
            }
        }
        return result;
    }

    public void initSearchHumansMenu(){
        String request = inputParam("запрос (Фамилию Имя Отчество)");
        presenter.searchHuman(request);
    }

    private int inputLocalDateParam(int minValue, int maxValue, String param){
        boolean stopFlag = false;
        int result = 0;
        while(!stopFlag){
            System.out.print("Введите " + param + ": ");
            String inputStr = scanner.nextLine();
            if(isInt(inputStr)){
                result = Integer.parseInt(inputStr);
                if(result <= maxValue && result >= minValue ){
                    stopFlag = true;
                } else {
                    System.out.println(param + " не может быть \"" + inputStr + "\"");
                }
            } else {
                System.out.println("Нужно ввести цифру!");
            }
        }
        return result;
    }

    private LocalDate inputDate(){
        int day = inputLocalDateParam(1, 31, "Число");
        int month = inputLocalDateParam(1, 12, "Месяц");
        int year = inputLocalDateParam(0, 99999, "Год");
        return LocalDate.of(year, month, day);
    }

    private LocalDate inputBirthDay(){
        System.out.println("Дата рождения");
            return inputDate();
    }

    private LocalDate inputDeathDay(){
        if(!yesNoQuestion("Человек жив?")){
            System.out.println("Дата смерти");
            return inputDate();
        }
        return null;
    }

    public LocalDate inputLocalDate(LocalDatesTypes localDateType){
        switch (localDateType){
            case DateOfBirth -> {
                return inputBirthDay();
            }
            case DateOfDeath -> {
                return inputDeathDay();
            }
        }
        return null;
    }

    private String inputProfession(){
        return inputParam("профессию");
    }

    private String inputNationality(){
        return inputParam("национальность");
    }

    private String inputName(){
        return inputParam("имя");
    }

    private String inputPatronymic(){
        return inputParam("отчество");
    }

    private String inputSurname(){
        return inputParam("фамилию");
    }

    private void uploadMenu(Menu menu){
        System.out.println(menu.showMenu());
        int choice = inputChoiceMenuItem(menu.size());
        menu.execute(choice);
    }

    public void initChooseGenderMenu(){
        chooseGenderMenu = new ChooseGender(this);
        uploadMenu(chooseGenderMenu);
    }

    private boolean isInt(String input){
        try{
            Integer.parseInt(input);
        } catch (Exception e){
            return false;
        }
        return true;
    }

    private int inputChoiceMenuItem(int menuSize){
        boolean success = false;
        int result = 0;
        if(menuSize == 0){
            System.out.println("Нажмите Enter...");
            scanner.nextLine();
            return -1;
        }
        while (!success){
            String choice = scanner.nextLine();
            if (isInt(choice)){
                result = Integer.parseInt(choice);
                if(result <= menuSize + 1){
                    success = true;
                }
            }
        }
        return result;
    }

    public void addMore(){
        if(yesNoQuestion("Добавить еще?")){
            initInputDataAddHuman();
        } else {
            mainMenu();
        }
    }

    public void getFamilyTreeInfo(){
        presenter.getFamilyTreeInfo();
        mainMenu();
    }

    public boolean askForReload(){
        return yesNoQuestion("В дереве есть данные. Загрузка может привести к их потере. Загрузить данные из файла?");
    }

    public void sortByName(){
        presenter.sortByName();
        savedFlag = false;
        mainMenu();
    }

    public void sortById(){
        presenter.sortById();
        savedFlag = false;
        mainMenu();
    }

    public void sortByAge(){
        presenter.sortByAge();
        savedFlag = false;
        mainMenu();
    }

    public void sortByBirthday(){
        presenter.sortByBirthday();
        savedFlag = false;
        mainMenu();
    }

    public String inputParam(String paramName){
        System.out.print("Введите " + paramName + ": ");
        return scanner.nextLine();
    }

    public void initChooseMotherMenu(){
        Map<String, Integer> fullNameId= presenter.getInfoForChooseParents(Gender.Female);
        System.out.println("Выбор матери");
        chooseParentMenu = new ChooseParent(Parents.Mother, fullNameId, this);
        uploadMenu(chooseParentMenu);
    }

    public void initChooseFatherMenu(){
        Map<String, Integer> fullNameId= presenter.getInfoForChooseParents(Gender.Male);
        System.out.println("Выбор отца");
        chooseParentMenu = new ChooseParent(Parents.Father, fullNameId, this);
        uploadMenu(chooseParentMenu);
    }

    public void saveFamTreeToFile(){
        String fileName = inputParam("имя файла");
        presenter.saveFamTreeToFile(fileName);
        savedFlag = true;
        mainMenu();
    }

    public void loadFamTreeFromFile(String fileName){
        presenter.loadFamTreeFromFile(fileName);
        savedFlag = true;
        mainMenu();
    }

    public void loadFamMenu(){
        loadFileMenu = new LoadFile(presenter.showSaveFiles(), this);
        uploadMenu(loadFileMenu);
    }

    public Human getHumanById(int id){
        return presenter.getHumanById(id);
    }

    public void exitProgram(){
        if (!savedFlag){
            if(yesNoQuestion("Сохранить данные перед завершением работы?")){
                saveFamTreeToFile();
            }
        }
        System.out.println("Завершение работы...");
        System.exit(0);
    }


}
