package view;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

import model.human.Gender;
import model.human.Human;
import presenter.Presenter;



public class ConsoleUI<Human>  implements View {
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
    public void start() {
        hello();
        while (work){
            System.out.println(menu.getMenu());
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            menu.execute(choice);
        }
    }

    public void addHuman () {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол: М/Ж");
        String gen = scanner.nextLine().toLowerCase();
        Gender gender = null;
        if(Objects.equals(gen, "м")){
            gender = Gender.Male;
        }
        else if (Objects.equals(gen, "ж")){
            gender = Gender.Female;
        }
        else{
            error();
        }
        System.out.println("Введите дату рождения в формате: гггг.мм.дд");
        String BDString = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(BDString, DateTimeFormatter.ofPattern("yyyy.MM.dd"));
//
//        System.out.println("Введите имя матери");


//        Human mother = (Human)scanner.nextLine();
//        System.out.println("Введите имя отца");
//        String father = scanner.nextLine();
//        System.out.println("Введите имя супруга/и");
//        String spouse = scanner.nextLine();
//        System.out.println("Введите дату смерти");
//        String DDString = scanner.nextLine();
//        LocalDate deathDate = LocalDate.parse(DDString, DateTimeFormatter.ofPattern("yyyy.MM.dd"));


        presenter.addHuman(name, gender, birthDate);
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTreeInfo() { presenter.getFamilyTreeInfo();}

    public void saveTree(){presenter.saveTree();}

    public void loadTree(){presenter.loadTree();}


    private void hello(){
        System.out.println("Доброго времени суток!");
    }
    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }


    private void error(){
        System.out.println("Вы ввели некорректные данные");
    }
}
