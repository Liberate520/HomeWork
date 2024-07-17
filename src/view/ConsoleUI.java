package view;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private MenuHandler menuHandler;
    private Presenter presenter;
    private InputHandler inputHandler;
    private HumanHandler humanHandler;
    private boolean work;

    public ConsoleUI() {
        Scanner scanner = new Scanner(System.in);
        inputHandler = new InputHandler(scanner);
        presenter = new Presenter(this);
        menuHandler = new MenuHandler(this);
        humanHandler = new HumanHandler(presenter, inputHandler);
        work = true;
    }

    @Override
    public void startWork() {
        greetings();
        presenter.readTree();
        selectItemFromMenu();
    }

    private static void greetings() {
        System.out.println("Добро пожаловать в программу семейного древа!\nПожалуйста выберите нужный Вам пункт из меню.");
    }

    private void selectItemFromMenu() {
        while (work) {
            System.out.println(menuHandler.getMenu());
            String choiceStr = inputHandler.getInput();
            if (inputHandler.isValidMenuChoice(choiceStr, menuHandler.size())) {
                int choice = Integer.parseInt(choiceStr);
                menuHandler.execute(choice);
            } else {
                System.out.println("Введён неверный пункт меню.\nВведите корректный номер из меню: от 1 до " + menuHandler.size());
            }
        }
    }

    public void finishWork() {
        work = false;
        System.out.println("До новых встреч!");
        presenter.sortById(); // Будет сохраняться дерево, отсортированное по ID
        presenter.saveTree();
    }

    public void sortById() {
        presenter.sortById();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        humanHandler.addHuman();
    }

    public void findByName() {
        humanHandler.findByName();
    }

    public void removeHuman() {
        humanHandler.removeHuman();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
