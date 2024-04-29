package family_TREE.view;

import family_TREE.presenter.Presenter;
import java.util.Scanner;

public class Console implements View {
    private static Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private final MainMenu mainMenu;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Добрый день! Выбирите дейстивие:");
        while (work) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
//          метод проверки на валидность strChoice -> error()
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }
//            System.out.println("1. Добавить нового человека");
//            System.out.println("2. Получить список людей");
//            System.out.println("3. Отсортировать по имени");
//            System.out.println("4. Отсортировать по возрасту");
//            System.out.println("5. Закончить работу");
//            String choice = scanner.nextLine();
//            switch (choice) {
//                case "1":
//                    addHuman();
//                    break;
//                case "2":
//                    getHumanList();
//                    break;
//                case "3":
//                    sortByName();
//                    break;
//                case "4":
//                    sortByDeathDate();
//                    break;
//                case "5":
//                    finish();
//                    break;
//                default:
//                    error();
//            }
//        }
//    }

    private void error() {
        System.out.println("Введено_неверное_значение");
    }

    public void finish() {
        System.out.println("До новых встреч!");
        work = false;
    }

    public void addHuman() {
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

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByDeathDate() {
        presenter.sortByDeathDate();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
