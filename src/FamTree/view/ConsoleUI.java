package FamTree.view;

import FamTree.model.ft.Gender;
import FamTree.model.ft.human.Human;
import FamTree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private final Scanner scanner;
    private boolean work;
    private Presenter presenter;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        Presenter presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void start(){
        System.out.println("Welcome to the FamTree view");
        while (work){
            System.out.println("Введите команду: ");
            System.out.println("1. Добавить");
            System.out.println("2. Получить список");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по возрасту");
            System.out.println("5. Завершить работу ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addItem();
                    break;
                case "2":
                    getItemsList(1L);
                    break;
                case "3":
                    getItemsListName("a");
                    break;
                case "4":
                    getItemsListAge();
                    break;
                case "5":
                    finish();
                    break;
                default:
                    System.out.println("не правильно что-то");
            }

        }
    };

    public void addItem() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения:");
        String db = scanner.nextLine();
        System.out.println("Введите пол:");
        String sex = scanner.nextLine();
        presenter.addItem(new Human(name, Gender.Male, LocalDate.of(1966,12,12)));
    }

    public void getItemsList(Long id) {
        presenter.getItemList(id);
    }

    public void getItemsListName(String name) {
        presenter.getItemListName(name);
    }

    public void getItemsListAge() {
        presenter.getItemListAge();
    }

    public void finish() {
        System.out.println("Все !!!");
        work = false;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    @Override
    public void stop() {

    }
}
