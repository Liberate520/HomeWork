package group.model.view;

import group.model.FamilyTree;
import group.model.Gender;
import group.model.Human;
import group.model.presenter.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private static Scanner scanner;
    private final Presenter presenter;
    private final boolean work;
    private final Menu menu;

    public ConsoleUI(SystemColor menu) {
        this.menu = new Menu(this);
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }


    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол (male/female)");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Отец");
        Human parent1 = Human.valueOf(scanner.nextLine());
        System.out.println("Мать");
        Human parent2 = Human.valueOf(scanner.nextLine());

        System.out.println("Дата рождения");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Дата смерти");
        LocalDate deathDate = LocalDate.parse(scanner.nextLine());


        presenter.addHuman(name,gender,parent1,parent2,birthDate,null);



    }



    public void addWedding(){
        int Id1 = 0;
        int Id2 = 0;
        System.out.println("Супруг");
        String Id1String = scanner.nextLine();

        System.out.println("Супруга");
        String Id2String = scanner.nextLine();
        presenter.addWedding( Id1,  Id2);
    }

    public  void getById (int Id){
        presenter.getById(Id);
    }

    public void addToParents(Human human){
        presenter.addToParents(human);
    }

    public void addToChildren(Human human){
        presenter.addToChildren(human);
    }



    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        FamilyTree FamilyTree;



        while (work){
            printMenu();
            execute();

        }

    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    public void sortByDeathDate() {
        presenter.sortByDeathDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumansListInfo() {
        presenter.getHumansListInfo();
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

    private boolean checkTextForInt(String text){
        if (text.matches("[1-7]+")){
            return true;
        } else {
            inputError();
            return false;
        }
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

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");


    }

    public void save(FamilyTree familyTree){
        presenter.save(familyTree);
    }
    public void read(){
        presenter.read();
    }
}
