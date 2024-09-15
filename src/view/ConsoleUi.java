package view;

import model.human.Gender;
import model.human.Human;
import model.tree.FamilyTree;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUi implements View{

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    private static final String inputErr = "Неверный ввод!";
    private Human human;
    //private FamilyTree familyTree;

    public ConsoleUi(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu(this);
    }


    @Override
    public void start() {
        hellow();
        while (work){
            printMenu();
            execute();
        }
    }

    //распечатать дерево
    //выбор человека
    //добавить родственную связь-- добавить родителя, ребенка, брата/сестру
    //установить дату смерти
    //отсортировать дерево-- по ID, по имени, по возрасту
    // загрузить/сохранить дерево
    //загрузить тестовый список
    //очистить дерево
    //завершить работу

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if(checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if(text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if(numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    public void finish(){
        System.out.println("РАБОТА ЗАВЕРШЕНА");
        work = false;
    }
    private void inputError(){
        System.out.println(inputErr);
    }
    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void hellow(){
        System.out.println("--== СЕМЕЙНОЕ ДЕРЕВО 1.0 ==--");
    }

    private void error(){
        System.out.println("Неверный выбор");
    }
    public void addHuman(){
        String name;
        Gender gender = null;
        LocalDate birthDay;
        boolean in = true;

        System.out.println("Введите имя: ");
        name = scanner.nextLine();

        System.out.println("Введите пол (М/Ж): ");
        while (in) {
            String genderIn = scanner.nextLine();
            if (genderIn.equals("М")) {
                gender = Gender.MALE;
                in = false;
            }else if (genderIn.equals("Ж")) {
                gender = Gender.FEMALE;
                in = false;
            }else {
                System.out.println("Неверный ввод! Введите \"М\" или \"Ж\"");
            }
        }

        System.out.println("Введите дату рождения: ");
        birthDay = inputDate();
        presenter.addHuman(name, gender, birthDay);
    }

    private LocalDate inputDate(){
        System.out.println("Введите год (xxxx): ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц (xx): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("введите день (хх): ");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate localDate;
        return localDate = LocalDate.of(year,month,day);
        //по хорошему, добавить проверки на правильность ввода чисел(чтоб исключения не выюрачывала),
        //и чтоб дата не превышала сегодняшнюю...
    }

    public void findHuman(int id){
        this.human = presenter.getById(id);
    }
    public void setDeath(){

        System.out.println("Введите ID человека: ");
        int id = Integer.parseInt(scanner.nextLine());
        LocalDate deathDay = inputDate();
        presenter.setDeathDay(id, deathDay);

    }

    public void printTree(){
        presenter.printTree();
    }
    public void setWedding(int h, int w){
        presenter.setWedding(h,w);
    }
    public void setDivorce(int h, int w){
        presenter.setDivorce(h,w);
    }
    public void setParent(int parentId, int humanId){
        presenter.setParent(parentId, humanId);
    }
    public void setChild(int childId, int humanId){
        presenter.setChild(childId, humanId);
    }
    public void removeHuman(int humanId){
        presenter.removeHuman(humanId);
    }
    public void saveTree(){
        presenter.saveTree();
    }
    public void loadTree(){
        presenter.loadTree();
    }
    public void sortById(){
        presenter.sortById();
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByAge(){
        presenter.sortByAge();
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
