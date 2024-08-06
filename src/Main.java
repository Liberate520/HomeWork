import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        Scanner scanner = new Scanner(System.in);
        FileHandler<Human> fileHandler = new FileHandler<>();

        // Пример добавления людей в генеалогическое древо
        Human john = new Human("1", "John", "Doe", 60, Human.Gender.Male, LocalDate.of(1964, 1, 1));
        Human jane = new Human("2", "Jane", "Doe", 58, Human.Gender.Female, LocalDate.of(1966, 2, 1));
        Human mary = new Human("3", "Mary", "Smith", 30, Human.Gender.Female, LocalDate.of(1994, 3, 1));
        Human tom = new Human("4", "Tom", "Smith", 32, Human.Gender.Male, LocalDate.of(1992, 4, 1));

        john.addChild(mary);
        jane.addChild(mary);
        mary.setFather(john);
        mary.setMother(jane);

        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(mary);
        familyTree.addMember(tom);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Найти человека по ID");
            System.out.println("2. Найти человека по имени");
            System.out.println("3. Найти человека по фамилии");
            System.out.println("4. Получить информацию о детях человека");
            System.out.println("5. Сохранить семейное древо");
            System.out.println("6. Загрузить семейное древо");
            System.out.println("7. Сортировать по возрасту");
            System.out.println("8. Сортировать по полу");
            System.out.println("9. Выйти");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Введите ID: ");
                    String id = scanner.nextLine();
                    Human human = familyTree.getMemberById(id);
                    if (human != null) {
                        System.out.println(human);
                    } else {
                        System.out.println("Человек с таким ID не найден.");
                    }
                }
                case 2 -> {
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    List<Human> humansByName = familyTree.getMemberByName(name);
                    if (humansByName.isEmpty()) {
                        System.out.println("Человек с таким именем не найден.");
                    } else {
                        humansByName.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("Введите фамилию: ");
                    String surname = scanner.nextLine();
                    List<Human> humansBySurname = familyTree.getMemberByName(surname);
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
                    System.out.print("Введите имя файла для сохранения: ");
                    String filename = scanner.nextLine();
                    try {
                        fileHandler.saveFamilyTree(familyTree, filename);
                        System.out.println("Семейное древо сохранено.");
                    } catch (IOException e) {
                        System.out.println("Ошибка при сохранении файла: " + e.getMessage());
                    }
                }
                case 6 -> {
                    System.out.print("Введите имя файла для загрузки: ");
                    String filename = scanner.nextLine();
                    try {
                        familyTree = fileHandler.loadFamilyTree(filename);
                        System.out.println("Семейное древо загружено.");
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Ошибка при загрузке файла: " + e.getMessage());
                    }
                }
                case 7 -> {
                    System.out.println("Сортировка по возрасту:");
                    List<Human> sortedByAge = familyTree.sortByAge(Comparator.comparingInt(Human::getAge));
                    sortedByAge.forEach(System.out::println);
                }
                case 8 -> {
                    System.out.println("Сортировка по полу:");
                    List<Human> sortedByGender = familyTree.sortByGender(Comparator.comparing(Human::getGender));
                    sortedByGender.forEach(System.out::println);
                }
                case 9 -> {
                    System.out.println("Выход.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}