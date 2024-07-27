import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);

        // Пример добавления людей в генеалогическое древо
        Human john = new Human("1", "John", "Doe", 60, Human.Gender.Male, LocalDate.of(1964, 1, 1));
        Human jane = new Human("2", "Jane", "Doe", 58, Human.Gender.Female, LocalDate.of(1966, 2, 1));
        Human mary = new Human("3", "Mary", "Smith", 30, Human.Gender.Female, LocalDate.of(1994, 3, 1));
        Human tom = new Human("4", "Tom", "Smith", 32, Human.Gender.Male, LocalDate.of(1992, 4, 1));

        john.addChild(mary);
        jane.addChild(mary);
        mary.setFather(john);
        mary.setMother(jane);

        familyTree.addHuman(john);
        familyTree.addHuman(jane);
        familyTree.addHuman(mary);
        familyTree.addHuman(tom);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Найти человека по ID");
            System.out.println("2. Найти человека по имени");
            System.out.println("3. Найти человека по фамилии");
            System.out.println("4. Получить информацию о детях человека");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите ID: ");
                    String id = scanner.nextLine();
                    Human human = familyTree.getHumanById(id);
                    if (human != null) {
                        System.out.println(human);
                    } else {
                        System.out.println("Человек с таким ID не найден.");
                    }
                }
                case 2 -> {
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    List<Human> humansByName = familyTree.getHumanByName(name);
                    if (humansByName.isEmpty()) {
                        System.out.println("Человек с таким именем не найден.");
                    } else {
                        humansByName.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Введите фамилию: ");
                    String surname = scanner.nextLine();
                    List<Human> humansBySurname = familyTree.getHumanBySurname(surname);
                    if (humansBySurname.isEmpty()) {
                        System.out.println("Человек с такой фамилией не найден.");
                    } else {
                        humansBySurname.forEach(System.out::println);
                    }
                }
                case 4 -> {
                    System.out.print("Введите ID человека для получения информации о его детях: ");
                    String id = scanner.nextLine();
                    List<Human> children = familyTree.getAllChildren(id);
                    if (children.isEmpty()) {
                        System.out.println("У этого человека нет детей или ID неверен.");
                    } else {
                        System.out.println("Дети человека с ID " + id + ":");
                        children.forEach(System.out::println);
                    }
                }
                case 5 -> {
                    System.out.println("Выход.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}