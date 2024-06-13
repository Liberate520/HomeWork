package family_tree_app.view;

import java.util.Scanner;

import family_tree_app.presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Let's begin");
        while (work) {
            System.out.println(mainMenu.showMenu());
            String choiceString = scanner.nextLine();
            if (checkChoice(choiceString)) {
                int choice = Integer.parseInt(choiceString);
                mainMenu.makeAction(choice);
            } else
                continue;
        }
    }

    private boolean checkChoice(String choiceString) {
        if (choiceString.matches("[0-9]*")) {
            int choice = Integer.parseInt(choiceString);
            return choice >= 1 && choice <= mainMenu.size();
        }
        return false;
    }

    public void finish() {
        System.out.println("See you later!");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAmountOfChildren() {
        presenter.sortByAmountOfChildren();
    }

    public void getList() {
        presenter.getList();
    }

    public void showMen() {
        presenter.showMen();
    }

    public void showWomen() {
        presenter.showWomen();
    }

    public void showProgenitors() {
        presenter.showProgenitors();
    }

    public void addPerson() {
        presenter.addPerson();
        getList();
    }

    public void setParents() {
        presenter.setParents();
    }

    public void setPeriodOfLife() {
        presenter.setPeriodOfLife();
    }

    @Override
    public void print(String answer) {
        System.out.println(answer);
    }

    public void save() {
        presenter.save();
    }

    public void load() {
        presenter.load();
    }
}