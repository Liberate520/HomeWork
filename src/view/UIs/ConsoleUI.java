package view.UIs;

import model.family.human.Gender;
import presenter.Presenter;
import view.UIs.commands.Command;
import view.UIs.helpers.CheckNumber;
import view.View;

import java.time.LocalDate;
import java.util.Scanner;


public class ConsoleUI implements View {
    private Presenter presenter;
    private Menu menu;
    Scanner scanner;

    public ConsoleUI() {
        this.presenter = new Presenter(this);
//        this.command = new Command();
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(this);
    }

    @Override
    public void start() {
        menu.menu();
    }

    @Override
    public void answer(String answer) {
        System.out.println(answer);
    }

    public void menu(){
        System.out.println("Menu:");
    }

    /**
     *   commands.add(new AddHumanCom("Добавить человека", view));
     *         commands.add(new GetHumanCom("Получить человека по ID", view));
     *         commands.add(new SetParentCom("Установить родителя", view));
     *         commands.add(new PrintTreeCom("Показать дерево", view));
     *         commands.add(new GetSiblingsCom("Показать братьев и сестер", view));
     *         commands.add(new GetAncestorsCom("Показать предков", view));
     *         commands.add(new GetDescendantsCom("Показать потомков", view));
     */

    public void addHuman(){
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате YYYY-MM-DD");
        boolean flag = true;
        LocalDate birthDate = LocalDate.of(1,1,1);
        while (flag) {
            String input = scanner.nextLine();
            if (input.matches("^\\d{4}-[0-12]{2}-\\d{2}")) {
                birthDate = LocalDate.parse(input);
                flag = false;
            } else System.out.println("Неверный формат");
        }
        System.out.println("Выберите пол: 1. Муж; 2. Жен");
        String choice = scanner.nextLine();
        Gender gender = Gender.Male;
        flag = true;
        while (flag) {
            switch (choice) {
                case "1":
                    gender = Gender.Male;
                    flag = false;
                    break;
                case "2":
                    gender = Gender.Female;
                    flag = false;
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
        presenter.addHuman(name, birthDate, gender);
    }

    public void getById(){
        System.out.println("Введите айди человека");
        int id = getNumberFromConsole();
//        if (id > -1){
            presenter.getHuman(id);
//        }
    }

    public void printTree(){
        presenter.printTree();
    }

    public void setParent(){
        int childId;
        int parentId;
        System.out.println("Введите айди ребенка");
        childId = getNumberFromConsole();
        System.out.println("Введите айди родителя");
        parentId = getNumberFromConsole();
//        if (childId > -1 && parentId > -1)
            presenter.setParent(childId, parentId);
    }

    public void getSiblings(){
        System.out.println("Введите айди человека");
        int id;
        id = getNumberFromConsole();
//        if (id > -1) {
            presenter.getSiblings(id);
//        }
    }

    public void getAncestors(){
        int id;
        int gen;
        System.out.println("Введите айди человека");
        id = getNumberFromConsole();
        System.out.println("Введите кол-вл поколений");
        gen = getNumberFromConsole();
        presenter.getAncestors(id, gen);

    }

    public void getDescendants(){
        int id;
        int gen;
        System.out.println("Введите айди человека");
        id = getNumberFromConsole();
        System.out.println("Введите кол-вл поколений");
        gen = getNumberFromConsole();
        presenter.getDescendants(id, gen);
    }

    public void getChildren(){
        System.out.println("Введите айди родителя");
        int id = getNumberFromConsole();
        presenter.getChildren(id);
    }

    public void exit(){
        menu.setFlag(false);
        System.out.println("Пока!");
    }
    private void printLD () {

        boolean flag = true;
        while (flag) {
            String input = scanner.nextLine();
            if (input.matches("^\\d{4}-[1-12]{2}-\\d{2}")) {
                LocalDate ld = LocalDate.parse(input);
                System.out.println(ld.toString());
                flag = false;
            } else System.out.println("Неверный формат");
        }
    }

    private int getNumberFromConsole(){
        String input;
        int number = -1;
        input = scanner.nextLine();
        if (CheckNumber.isNumber(input)){
            number = Integer.parseInt(input);
        }
        return number;
    }
}
