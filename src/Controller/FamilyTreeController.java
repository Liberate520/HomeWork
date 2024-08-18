package Controller;

import Model.FamilyTree;
import Model.Person;
import Util.FileManager;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class FamilyTreeController {
    private FamilyTree familyTree;
    private FileManager fileManager;

    public FamilyTreeController(FamilyTree<Person> familyTree, FileManager fileManager) {
        this.familyTree = familyTree;
        this.fileManager = fileManager;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Установить родителей");
            System.out.println("3. Показать всех людей");
            System.out.println("4. Найти по имени");
            System.out.println("5. Показать детей");
            System.out.println("6. Показать родителей");
            System.out.println("7. Сохранить дерево");
            System.out.println("8. Загрузить дерево");
            System.out.println("0. Выход");

            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    setParents(scanner);
                    break;
                case 3:
                    showAllPeople(scanner);
                    break;
                case 4:
                    findByName(scanner);
                    break;
                case 5:
                    showChildren(scanner);
                    break;
                case 6:
                    showParents(scanner);
                    break;
                case 7:
                    saveTree(scanner);
                    break;
                case 8:
                    loadTree(scanner);
                    break;
                case 0:
                    System.out.println("Выход из программы...");
                    return;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private void addPerson(Scanner scanner) {
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();

        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();

        // Ввод даты рождения с проверкой
        LocalDate birthDate = null;
        while (birthDate == null) {
            System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
            String birthDateStr = scanner.nextLine();
            try {
                birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
            }
        }

        // Ввод даты смерти с проверкой
        LocalDate deathDate = null;
        while (deathDate == null) {
            System.out.print("Введите дату смерти (ГГГГ-ММ-ДД или оставьте пустым): ");
            String deathDateStr = scanner.nextLine();
            if (deathDateStr.isEmpty()) {
                break; // Если строка пустая, не устанавливаем дату смерти
            }
            try {
                deathDate = LocalDate.parse(deathDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                System.out.println("Неправильный формат даты. Пожалуйста, используйте формат ГГГГ-ММ-ДД.");
            }
        }

        // Ввод пола с проверкой
        Person.Gender gender = null;
        while (gender == null) {
            System.out.print("Введите пол (МУЖЧИНА/ЖЕНЩИНА): ");
            try {
                gender = Person.Gender.valueOf(scanner.nextLine().toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Некорректный ввод пола. Пожалуйста, введите МУЖЧИНА или ЖЕНЩИНА.");
            }
        }

        Person person = new Person(firstName, lastName, birthDate, deathDate, gender);
        familyTree.addPerson(person);

        System.out.println("Член семьи успешно добавлен!");
    }

    private void setParents(Scanner scanner) {
        System.out.print("Введите ID ребенка: ");
        int childId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Введите ID матери: ");
        int motherId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Введите ID отца: ");
        int fatherId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.setParents(childId, motherId, fatherId);
    }

    private void showAllPeople(Scanner scanner) {
//      Сортировка членов семьи перед выводом
        System.out.println("Выберите по какому признаку вы хотите отсортировать:");
        System.out.println("1. По имени");
        System.out.println("2. По дате рождения");
        int sortChoice = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch (sortChoice) {
            case 1:
                familyTree.sort();
                break;
            case 2:
                familyTree.sortByBirthDate();
                break;
            default:
                System.out.println("Некорректный выбор. Будет использована сортировка по имени.");
                familyTree.sort();
                break;
        }

        List<Person> people = familyTree.getAllPeople();
        if (people.isEmpty()) {
            System.out.println("В дереве пока нет членов семьи.");
        } else {
            System.out.println("Члены семьи:");
            for (Object person : people) {
                System.out.println(person);
            }
        }
//        for (Object person : familyTree.getAllPeople()) {
//            System.out.println(person);
//        }
    }

    private void findByName(Scanner scanner) {
        System.out.print("Введите ID, имя или фамилию для поиска: ");
        String searchInput = scanner.nextLine();

        if (searchInput.matches("\\d+")) { // Проверка, является ли ввод числом
            int searchId = Integer.parseInt(searchInput);
            Person personById = (Person) familyTree.getPerson(searchId);
            if (personById != null) {
                System.out.println(personById);
                familyTree.getParents(searchId);
                familyTree.getChildren(searchId);
            } else {
                System.out.println("Член семьи с таким ID не найден.");
            }
        } else {
            // Если не число, ищем по имени и/или фамилии
            String[] nameParts = searchInput.split(" ");
            List matchedPeople;

            if (nameParts.length == 2) {
                // Если пользователь ввел и имя, и фамилию
                matchedPeople = familyTree.findByName(nameParts[0], nameParts[1]);
            } else {
                // Если введено одно слово, ищем по имени и фамилии
                matchedPeople = familyTree.findByName(searchInput, searchInput);
            }

            if (!matchedPeople.isEmpty()) {
                System.out.println("Найдены следующие члены семьи:");
                for (Object person : matchedPeople) {
                    System.out.println(person);
                }
            } else {
                System.out.println("Член семьи с таким именем или фамилией не найден.");
            }
        }
    }

    private void showChildren(Scanner scanner) {
        System.out.print("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.getChildren(personId);
    }

    private void showParents(Scanner scanner) {
        System.out.print("Введите ID человека: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        familyTree.getParents(personId);
    }

    private void saveTree(Scanner scanner) {
        System.out.print("Введите имя файла для сохранения (без расширения): ");
        String fileName = scanner.nextLine();

        if (!fileName.endsWith(".dat")) {
            fileName += ".dat";
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree);
            System.out.println("Дерево семьи успешно сохранено в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }

    private void loadTree(Scanner scanner) {
        System.out.print("Введите имя файла для загрузки (без расширения): ");
        String fileName = scanner.nextLine();

        if (!fileName.endsWith(".dat")) {
            fileName += ".dat";
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            familyTree = (FamilyTree<Person>) ois.readObject();
            System.out.println("Дерево семьи успешно загружено из файла " + fileName);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке файла: " + e.getMessage());
        }
    }
}
