package view;

import model.Gender.Gender;
import presenter.Presenter;
import view.check.Check;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private  boolean work;
    private  MainMenu menu;
    private Check check;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
        check = new Check(menu);
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать");
        while (work){
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            if (check.checkChoice(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                menu.execute(choice);
            }
        }

    }

    public void finish() {
        Save();
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

    public void Save() {
        presenter.Save();
        System.out.println("Семейное дерево успешно сохранено!");
    }

    private ArrayList<Integer> getId(){
        ArrayList<Integer> ids = new ArrayList<>();
        showFamilyTree();
        System.out.println("Введите id ребёнка");
        String idChildStr = scanner.nextLine();
        if (!check.checkIntId(idChildStr)) {
            System.out.println("Неверный id. Попробуйте ещё раз");
            return null;
        }
        int idChild = Integer.parseInt(idChildStr);
        ids.add(idChild);


        System.out.println("Введите id родителя");
        String idParentStr = scanner.nextLine();
        if (!check.checkIntId(idParentStr) || Objects.equals(idParentStr, idChildStr)) {
            System.out.println("Неверный id. Попробуйте ещё раз");
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

    public void ReadFamilyTree() {
        presenter.ReadFamilyTree();
        System.out.println("Семейное дерево загружено");
    }
}
