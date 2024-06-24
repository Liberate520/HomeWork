package Family_tree.view;

import ru.gb.Family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter = new Presenter(this);
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Доброго времени суток!");

        while (work) {
            System.out.println(mainMenu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.execute(choice);
        }

    }

    public void add(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите пол:  ");
        String gender = scanner.nextLine();
        System.out.println("Введите дату рождения: ");
        String birthDate = scanner.nextLine();

        presenter.add(name, gender, birthDate);
    }

    private void getInfo(){
        presenter.getInfo();
    }

    private void sortName(){
        presenter.sortName();
    }

    private void sortBirthDate(){
        presenter.sortBirthDate();
    }

    private void finish(){
        work = false;
        System.out.println("Всего доброго");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
