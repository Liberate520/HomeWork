package family_TREE.view;

import family_TREE.presenter.Presenter;
import java.util.Scanner;

public class Console implements View {

    private static Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void start() {
        System.out.println("Добрый день! Выбирите дейстивие:");
        while (true) {
            System.out.println("1. Добавить нового человека");
            System.out.println("2. Получить список людей");
            System.out.println("3. Отсортировать по имени");
            System.out.println("4. Отсортировать по возрасту");
            System.out.println("5. Закончить работу");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    getHumanList(presenter);
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByDeathDate();
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Введено неверное значение");
            }
        }
//        while (work){
//            System.out.println(menu.print());
//            String choice = scanner.nextLine();
//            menu.execute(choice);
//        }
    }



    private void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите пол");
        String gender = scanner.nextLine();
        System.out.println("Укажите дату рождения");
        String birthDate = scanner.nextLine();
        System.out.println("Укажите отца");
        long idFather = Long.parseLong(scanner.nextLine());
        System.out.println("Укажите мать");
        long idMother = Long.parseLong(scanner.nextLine());
        presenter.addHuman(name, gender, birthDate, idFather, idMother);
    }

    public void getHumanList(){
        presenter.getHumanList();
    }

    private static void sortByName() {
        presenter.sortByName()
        ;
    }

    private void sortByDeathDate() {
        presenter.sortByDeathDate();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
