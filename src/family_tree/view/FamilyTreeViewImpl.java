package family_tree.view;

import family_tree.person.Person;
import family_tree.util.GenealogyTree;
import family_tree.view.FamilyTreeView;
import family_tree.writable.CSVFileHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FamilyTreeViewImpl implements FamilyTreeView {

    private Scanner scanner = null;
    private final GenealogyTree<Person> tree;
    private final CSVFileHandler csvFileHandler;

   public FamilyTreeViewImpl(GenealogyTree<Person> tree, CSVFileHandler csvFileHandler) {
    this.tree = tree;
    this.csvFileHandler = csvFileHandler;
    this.scanner = new Scanner(System.in);
}


    public FamilyTreeViewImpl() {

        tree = null;
        csvFileHandler = null;
    }

    @Override
    public void displayFamilyTree(Map<Integer, Person> familyTree) {
        // Вывод информации о людях в древе
        System.out.println("Информация о всех людях в древе:");
        for (Person person : familyTree.values()) {
            System.out.println(person);
        }
    }

    @Override
    public void displayErrorMessage(String message) {
        System.out.println("Ошибка: " + message);
    }

    @Override
    public void displaySuccessMessage(String message) {
        System.out.println("Успех: " + message);
    }

    @Override
    public int promptForPersonId() {
        return 0;
    }

    @Override
    public String promptForPersonName() {
        return null;
    }

    @Override
    public String promptForPersonGender() {
        return null;
    }

    @Override
    public int promptForPersonAge() {
        return 0;
    }

    @Override
    public int promptForSpouseId() {
        return 0;
    }

    @Override
    public int promptForMotherId() {
        return 0;
    }

    @Override
    public int promptForFatherId() {
        return 0;
    }

    @Override
    public int promptForChildId() {
        return 0;
    }

    // Остальные методы интерфейса

    @Override
    public void showMenu() {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить человека в древо");
            System.out.println("2. Показать семейное древо");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по возрасту");
            System.out.println("5. Закончить работу");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    // Добавить человека в древо
                    addPerson();
                    break;
                case 2:
                    // Показать семейное древо
                    displayFamilyTree();
                    break;
                case 3:
                    // Сортировать по имени
                    sortByFirstName();
                    break;
                case 4:
                    // Сортировать по возрасту
                    sortByAge();
                    break;
                case 5:
                    // Закончить работу
                    isRunning = false;
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private void sortByAge() {
        // Реализация сортировки по возрасту
        System.out.println("Реализация сортировки по возрасту...");
    }

    private void sortByFirstName() {
        // Реализация сортировки по имени
        System.out.println("Реализация сортировки по имени...");
    }

    private void displayFamilyTree() {
        // Реализация отображения семейного древа
        System.out.println("Реализация отображения семейного древа...");
    }

    private void addPerson() {
        // Реализация добавления человека в древо
    System.out.println("Введите имя:");
    String name = scanner.nextLine();

    System.out.println("Введите фамилию:");
    String surname = scanner.nextLine();

    System.out.println("Введите возраст:");
    int age = scanner.nextInt();
    scanner.nextLine(); // Очищаем буфер после nextInt()

    System.out.println("Выберите пол (нажмите 1 для мужчины или 2 для женщины):");
    int genderChoice = scanner.nextInt();
    scanner.nextLine(); // Очищаем буфер после nextInt()

    String gender;
    if (genderChoice == 1) {
        gender = "male";
    } else if (genderChoice == 2) {
        gender = "female";
    } else {
        System.out.println("Некорректный выбор. Попробуйте снова.");
        return;
    }

    // Создаем объект Person
    Person person = new Person(name, surname, gender, age);

    // Добавляем человека в древо
    tree.addElement(person.getId(), person);

    // Выводим сообщение о том, что человек сохранен в список
    System.out.println("Человек успешно добавлен в список.");

    // Сохраняем обновленное древо в файл
    Map<Integer, Person> updatedFamilyTree = new HashMap<>();
    for (Person p : tree.getAllElements()) {
        updatedFamilyTree.put(p.getId(), p);
    }
    csvFileHandler.writeToFile(updatedFamilyTree);
}

    private void continueAddingPerson() {
        // Реализация продолжения ввода информации о человеке
    }
}
