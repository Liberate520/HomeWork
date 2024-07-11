import FamilyTree.FamilyTree;
import FamilyTree.Person;
import Interfaces.TreeIO;
import Interfaces.TreeIOImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static FamilyTree familyTree = new FamilyTree();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static TreeIO treeIO = new TreeIOImpl();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Найти человека по имени");
            System.out.println("3. Получить всех детей выбранного человека");
            System.out.println("4. Создать новое дерево");
            System.out.println("5. Показать всех людей в дереве");
            System.out.println("6. Сохранить дерево в файл");
            System.out.println("7. Загрузить дерево из файла");
            System.out.println("8. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPersonByName();
                    break;
                case 3:
                    getChildren();
                    break;
                case 4:
                    createNewTree();
                    break;
                case 5:
                    showAllPeople();
                    break;
                case 6:
                    saveTreeToFile();
                    break;
                case 7:
                    loadTreeFromFile();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
            }
        }
    }

    private static void addPerson() {
        try {
            System.out.print("Введите имя: ");
            String name = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String surname = scanner.nextLine();
            System.out.print("Введите дату рождения (yyyy-MM-dd): ");
            Date birthDate = dateFormat.parse(scanner.nextLine());
            System.out.print("Введите дату смерти (если есть, yyyy-MM-dd, иначе оставьте пустым): ");
            String deathDateString = scanner.nextLine();
            Date deathDate = deathDateString.isEmpty() ? null : dateFormat.parse(deathDateString);

            Person person = new Person(name, surname, birthDate, deathDate);
            familyTree.addPerson(person);

            System.out.print("Введите имя отца (если есть): ");
            String fatherName = scanner.nextLine();
            if (!fatherName.isEmpty()) {
                Person father = familyTree.findPersonByName(fatherName);
                if (father != null) {
                    person.setFather(father);
                    father.addChild(person);
                } else {
                    System.out.println("Отец не найден в дереве.");
                }
            }

            System.out.print("Введите имя матери (если есть): ");
            String motherName = scanner.nextLine();
            if (!motherName.isEmpty()) {
                Person mother = familyTree.findPersonByName(motherName);
                if (mother != null) {
                    person.setMother(mother);
                    mother.addChild(person);
                } else {
                    System.out.println("Мать не найдена в дереве.");
                }
            }
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, используйте формат yyyy-MM-dd.");
        }
    }

    private static void findPersonByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        Person person = familyTree.findPersonByName(name);
        if (person != null) {
            System.out.println("Человек найден: " + person);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private static void getChildren() {
        System.out.print("Введите имя человека, чтобы получить всех его детей: ");
        String name = scanner.nextLine();
        Person person = familyTree.findPersonByName(name);
        if (person != null) {
            List<Person> children = familyTree.getChildren(person);
            if (children.isEmpty()) {
                System.out.println("У этого человека нет детей.");
            } else {
                System.out.println("Дети " + person.getName() + ":");
                for (Person child : children) {
                    System.out.println(child);
                }
            }
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private static void createNewTree() {
        familyTree.createNewTree();
        System.out.println("Новое дерево создано.");
    }

    private static void showAllPeople() {
        List<Person> people = familyTree.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("В дереве нет людей.");
        } else {
            System.out.println("Все люди в дереве:");
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }

    private static void saveTreeToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String filename = scanner.nextLine();
        try {
            treeIO.saveToFile(familyTree, filename);
            System.out.println("Дерево сохранено в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении дерева в файл: " + e.getMessage());
        }
    }

    private static void loadTreeFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String filename = scanner.nextLine();
        try {
            familyTree = treeIO.loadFromFile(filename);
            System.out.println("Дерево загружено из файла " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке дерева из файла: " + e.getMessage());
        }
    }
}

