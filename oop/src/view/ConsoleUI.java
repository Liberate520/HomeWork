package view;

import model.man.Gender;
import model.man.Man;
import presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private MainMenu menu;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu = new MainMenu(this);
        work = true;
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
    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }
    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTreeInfo() {
        System.out.println(presenter.getFamilyTreeInfo());
    }
    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private String name(){
        System.out.println("ВВеди имя человека:");
        String name = scanner.nextLine();
        return name;
    }
    private Gender gender() {
        System.out.println("Если это мужчина нажми 1, если женщина 2");
        String choice = scanner.nextLine();
        while (!choice.equals("1") && !choice.equals("2")) {
            System.out.println("Если это мужчина нажми 1, если женщина 2");
            choice = scanner.nextLine();
        }
            if (choice.equals("1")) {
                return Gender.Male;
            } else {
                return Gender.Female;
            }
    }
    private LocalDate date(){
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateString, formatter);
    }
    private long askId(){
        System.out.println("Введи id человека");
        String stringId = scanner.nextLine();
        while (!checkTextForInt(stringId)){
            stringId = scanner.nextLine();
        }
        long id = Long.parseLong(stringId);
        return id;
    }
    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }

    public void addLivingItem(){
        String name = name();
        Gender gender1= gender();
        System.out.println("Введи дату рождения в фомате дата.месяц.год");
        LocalDate birthDate = date();
        presenter.addLivingItem(name, gender1, birthDate);
    }
    public void addDeathItem(){
        String name = name();
        Gender gender1= gender();
        System.out.println("Введи дату рождения в фомате дата.месяц.год");
        LocalDate birthDate = date();
        System.out.println("Введи дату рождения в фомате дата.месяц.год");
        LocalDate deathDate = date();
        presenter.addDeathItem(name, gender1, birthDate, deathDate);
    }

    public void addItemWithParent(){
        String name = name();
        Gender gender1= gender();
        System.out.println("Введи дату рождения в фомате дата.месяц.год");
        LocalDate birthDate = date();
        System.out.println("Кто является матерью человека в данном древе?\n");
        long mather = askId();
        System.out.println("Кто является отцом человека в данном древе?\n");
        long father = askId();
        presenter.addItemWithParent(name, gender1, birthDate, mather, father);
    }
    public void getInfoManForId(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("О ком хотите подробную информацию?\n");
        long id = askId();
        System.out.println(presenter.getInfoManForId(id));
    }
    public void addChildById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Кто является родителем в данном древе?\n");
        long parent = askId();
        System.out.println("Кто является ребенком в данном древе?\n");
        long child = askId();
        presenter.addChildById(parent, child);
    }
    public void addParentById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Кто является ребенком в данном древе?\n");
        long child = askId();
        System.out.println("Кто является родителем в данном древе?\n");
        long parent = askId();
        presenter.addParentById(child, parent);
    }
    public void removeById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Кого удалить?\n");
        presenter.removeById(askId());
    }
    public void getParentById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Чьих родителей найти?\n");
        long child = askId();
        List<Man> parents = presenter.getParentById(child);
        for (Man man : parents) {
            System.out.println(man.getInfo());
        }
    }
    public void getChildrensById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Чьих детей найти?\n");
        long parent = askId();
        List<Man> childrens = presenter.getChildrensById(parent);
        for (Man man : childrens) {
            System.out.println(man.getInfo());
        }
    }
    public void getByName(){
        System.out.println("Введите имя для поиска?\n");
        String name = scanner.nextLine();
        List<Man> mans = presenter.getByName(name);
        for (Man man : mans) {
            System.out.println(man.getInfo());
        }
    }
    public void setWeddingById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Кто первый супруг?\n");
        long id1 = askId();
        System.out.println("Кто второй супруг?\n");
        long id2 = askId();
        presenter.setWeddingById(id1, id2);
    }
    public void setDivorceById(){
        presenter.getFamilyTreeInfo();
        System.out.println("-".repeat(80));
        System.out.println("Кто первый супруг для развода?\n");
        long id1 = askId();
        System.out.println("Кто второй супруг для развода?\n");
        long id2 = askId();
        presenter.setDivorceById(id1, id2);
    }
    public void saveTree(){
        System.out.println("Сохранил древо!\n");
        presenter.saveTree();
    }
    public void loadTree(){
        System.out.println("Загрузил древо!\n");
        presenter.loadTree();
    }


    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }
}
