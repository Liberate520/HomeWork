package ru.gb.familytree.view;

import ru.gb.familytree.model.human.Gender;
import ru.gb.familytree.presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private TreeMenu treeMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        treeMenu = new TreeMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Ave, Caesar!");
        while (work) {
            System.out.println(treeMenu.getMenu());
            String strChoose = scanner.nextLine();
            //проверка на валидность
            int choose = Integer.parseInt(strChoose);
            treeMenu.execute(choose);
        }
    }

    public void finish() {
        System.out.println("Завершение работы...");
        work = false;
    }

    public void sortByAge() {
        presenter.sortTreeByAge();
    }

    public void sortByName() {
        presenter.sortTreeByName();
    }

    public void getTreeListInfo() {
        presenter.viewTree();
    }

    public void addSomeBody() {
        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст: ");
        String ageStr = scanner.nextLine();
        int age = Integer.parseInt(ageStr);
        System.out.println("Укажите пол (м/ж): ");
        String sex = scanner.nextLine();
        Gender gender = getSex(sex);
        presenter.addPerson(name, age, gender);

    }

    private Gender getSex(String str) {
        if (str.equals("ж")) {
            return Gender.FEMALE;
        }
        return Gender.MALE;
    }

    public void save() {
        presenter.saveTree();
    }

    public void load() {
        presenter.loadTree();
    }

    @Override
    public void printAnswers(String answer) {
        System.out.println(answer);
    }
}
