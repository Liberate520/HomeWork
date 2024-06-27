package view;

import model.Gender.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private  boolean work;
    private  MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            if (checkChoice(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                menu.execute(choice);
            }
        }

    }

    public void finish() {
        System.out.println("До встречи!");
        work = false;
    }

    public void findFamilyItemByName() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.findFamilyItemByName(name);
    }

    public void sortByName() {
        presenter.sortByName();
    }
    public void sortByAge() {
        presenter.sortByAge();
    }

    public void showFamilyTree() {
        presenter.showFamilyTree();
    }

    public void addFamilyItem() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Введите пол (Male/Female)");
        String strGender = scanner.nextLine();
        Gender gender = null;
        if (Objects.equals(strGender, "Male")){ gender = Gender.Male; }
        else if (Objects.equals(strGender, "Female")){ gender = Gender.Female; }

        System.out.println("Введите год рождения");
        String yearStr = scanner.nextLine();
        int year = Integer.parseInt(yearStr);
        System.out.println("Введите месяц рождения");
        String monthStr = scanner.nextLine();
        int month = Integer.parseInt(monthStr);
        System.out.println("Введите день рождения");
        String dayStr = scanner.nextLine();
        int day = Integer.parseInt(dayStr);
        presenter.addFamilyItem(name, gender, LocalDate.of(year, month, day));
    }

    public void AddParentOrChild() {
        ArrayList<Integer> ids = getId();
        presenter.AddParentOrChild(ids.get(0), ids.get(1));

    }


    private ArrayList<Integer> getId(){
        ArrayList<Integer> ids = new ArrayList<>();
        showFamilyTree();
        System.out.println("Введите индекс ребёнка");
        String idChildStr = scanner.nextLine();
        if (!checkIntId(idChildStr)) {
            System.out.println("Неверный индекс. Попробуйте ещё раз");
            return null;
        }
        int idChild = Integer.parseInt(idChildStr);
        ids.add(idChild);


        System.out.println("Введите индекс родителя");
        String idParentStr = scanner.nextLine();
        if (!checkIntId(idChildStr) || Objects.equals(idParentStr, idChildStr)) {
            System.out.println("Неверный индекс. Попробуйте ещё раз");
            return null;
        }
        int idParent = Integer.parseInt(idParentStr);
        ids.add(idParent);
        return ids;
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public boolean checkChoice(String choiceStr){
        if (choiceStr.matches("[0-9]*")){
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menu.size();
        }
        return false;
    }


    public boolean checkIntId(String idStr){
        if (idStr.matches("[0-9]*")){
            return true;
        }
        return false;
    }


}
