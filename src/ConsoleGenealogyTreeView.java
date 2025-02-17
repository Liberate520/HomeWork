import java.util.Scanner;
import java.time.LocalDate;

public class ConsoleGenealogyTreeView implements GenealogyTreeView {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showGenealogyTree(GenealogyTree tree) {
        System.out.println(tree);
    }

    @Override
    public void addButtonClickListener(Runnable listener) {
        System.out.println("Нажмите Enter, чтобы добавить человека...");
        scanner.nextLine();
        listener.run();
    }

    @Override
    public void addSortByNameButtonClickListener(Runnable listener) {
        System.out.println("Нажмите Enter, чтобы отсортировать по имени...");
        scanner.nextLine();
        listener.run();
    }

    @Override
    public void addSortByBirthDateButtonClickListener(Runnable listener) {
        System.out.println("Нажмите Enter, чтобы отсортировать по дате рождения...");
        scanner.nextLine();
        listener.run();
    }

    @Override
    public void addSaveButtonClickListener(Runnable listener) {
        System.out.println("Нажмите Enter, чтобы сохранить генеалогическое древо...");
        scanner.nextLine();
        listener.run();
    }

    @Override
    public void addLoadButtonClickListener(Runnable listener) {
        System.out.println("Нажмите Enter, чтобы загрузить генеалогическое древо...");
        scanner.nextLine();
        listener.run();
    }

    @Override
    public Person getPersonInput() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите год рождения:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождения:");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения:");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите пол (MALE/FEMALE):");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        return new Person(name, LocalDate.of(year, month, day), gender);
    }
}
