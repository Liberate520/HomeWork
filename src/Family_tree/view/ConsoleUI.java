package Family_tree.view;

import ru.gb.Family_tree.model.human.Gender;
import ru.gb.Family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter = new Presenter(this);
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Доброго времени суток!");

        while (work) {
            System.out.println("1. Добавить человека в семейное древо");
            System.out.println("2. Получить текущую информацию о семейном древе");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Окончание работы");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    add();
                    break;
                case "2":
                    getInfo();
                    break;
                case "3":
                    sortName();
                    break;
                case "4":
                    sortBirthDate();
                    break;
                case "5":
                    finish();
                    break;
                default:
                    System.out.println("Некорректные данные! Попробуйте еще раз.");
            }
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
