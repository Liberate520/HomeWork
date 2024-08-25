import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleGenealogyTreeView implements GenealogyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showGenealogyTree(GenealogyTree<Person> tree) {
        System.out.println("Генеалогическое древо:");
        System.out.println(tree);
    }

    @Override
    public void addButtonClickListener(Runnable listener) {
        System.out.println("Добавить нового человека (yes/no)? ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            listener.run();
        }
    }

    @Override
    public void addSortByNameButtonClickListener(Runnable listener) {
        System.out.println("Отсортировать по имени (yes/no)? ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            listener.run();
        }
    }

    @Override
    public void addSortByBirthDateButtonClickListener(Runnable listener) {
        System.out.println("Отсортировать по дате рождения (yes/no)? ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            listener.run();
        }
    }

    @Override
    public void addSaveButtonClickListener(Runnable listener) {
        System.out.println("Сохранить генеалогическое древо (yes/no)? ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            listener.run();
        }
    }

    @Override
    public void addLoadButtonClickListener(Runnable listener) {
        System.out.println("Загрузить генеалогическое древо (yes/no)? ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            listener.run();
        }
    }

    @Override
    public Person getPersonInput() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения (YYYY-MM-DD):");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Введите пол (MALE/FEMALE):");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        return new Person(name, birthDate, gender);
    }
}
