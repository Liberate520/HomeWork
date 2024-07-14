package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import family_tree.presenter.Presenter;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface implements View {
    private final Scanner scanner;
    private boolean work;
    private final Presenter presenter;
    private final MainMenu menu;


    public UserInterface() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    public void start() {
        System.out.println("Программа Генеалогическое Древо");
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            menu.execute(choice);
        }
    }

    public void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        presenter.addHuman(name, dob, gender);
        System.out.println("Человек добавлен! :)");
    }

    public void setParents() {
        System.out.print("Введите ID ребенка: ");
        int childId = Integer.parseInt(scanner.nextLine());

        System.out.print("Введите ID отца (или оставьте пустым, если неизвестен): ");
        String fatherIdStr = scanner.nextLine();
        Integer fatherId = fatherIdStr.isEmpty() ? null : Integer.parseInt(fatherIdStr);

        System.out.print("Введите ID матери (или оставьте пустым, если неизвестна): ");
        String motherIdStr = scanner.nextLine();
        Integer motherId = motherIdStr.isEmpty() ? null : Integer.parseInt(motherIdStr);

        presenter.setParents(childId, fatherId, motherId);
    }

    public void printAllHumans() {
        presenter.getHumanListInfo();
    }

    public void sortHumansByName() {
        presenter.sortByName();
    }

    public void sortHumansByDateBirth() {
        presenter.sortByDateBirth();
    }

    public void findHuman() {
        System.out.print("Введите имя или ID для поиска: ");
        String searchInput = scanner.nextLine();

        try {
            int searchId = Integer.parseInt(searchInput);
            Human human = presenter.findHumanById(searchId);
            if (human != null) {
                System.out.println("Найденный человек по ID:\n" + human);
            } else {
                System.out.println("Человек с ID " + searchId + " не найден.");
            }
        } catch (NumberFormatException e) {
            List<Human> humans = presenter.findHumansByName(searchInput);
            if (!humans.isEmpty()) {
                System.out.println("Найденные люди по имени:");
                for (Human human : humans) {
                    System.out.println(human);
                }
            } else {
                System.out.println("Человек с именем " + searchInput + " не найден.");
            }
        }
    }

    public void finish() {
        presenter.finish();
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
