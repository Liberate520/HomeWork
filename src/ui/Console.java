package Tree.homeWork.src.ui;

import Tree.homeWork.src.HumanGroup.Gender;
import Tree.homeWork.src.Presenter.Presenter;
import java.util.Scanner;
public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;
    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }
    @Override
    public void start() {
        System.out.println("Привет.");
        while (work) {
            System.out.println(menu.show());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            menu.execute(numCommand);
        }
    }
    public void finish(){
        System.out.println("Пока");
        work = false;
    }
    public void getHumanList(){
        presenter.getHumanList();
    }
    public void addHuman(){
        System.out.println("Введите имя и фамилию:");
        String name = scanner.nextLine();
        System.out.println("Введите пол:");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите дату рождения:");
        int DateOfBirth = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите дату смерти:");
        int DateOfDeath = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите имя матери:");
        String mother = scanner.nextLine();
        System.out.println("Введите имя отца:");
        String father = scanner.nextLine();
        presenter.addHuman(name, age, DateOfBirth, DateOfDeath, gender,
                father, mother);
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
