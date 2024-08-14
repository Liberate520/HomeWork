package Controller;

import Model.FamilyTree;
import Model.Person;
import Util.FileManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class FamilyTreeController {
    private FamilyTree<Person> familyTree;
    private FileManager fileManager;
    private Scanner scanner;

    public FamilyTreeController(FamilyTree<Person> familyTree, FileManager fileManager) {
        this.familyTree = familyTree;
        this.fileManager = fileManager;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести на экран всех членов семьи");
            System.out.println("2. Добавить нового члена семьи и установить его родственные связи");
            System.out.println("3. Найти члена семьи и посмотреть его родственные связи");
            System.out.println("4. Сохранить семейное дерево в файл");
            System.out.println("5. Загрузить семейное дерево из файла");
            System.out.println("6. Закончить работу");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера

            switch (choice) {
                case 1:
                    displayAllMembers();
                    break;
                case 2:
                    addNewMember();
                    break;
                case 3:
                    searchMember();
                    break;
                case 4:
                    saveTreeToFile();
                    break;
                case 5:
                    loadTreeFromFile();
                    break;
                case 6:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
                    break;
            }
        }
    }

    private void loadTreeFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String filename = scanner.nextLine();
        FamilyTree<Person> loadedTree = fileManager.loadFamilyTree(filename);
        if (loadedTree != null) {
            familyTree = loadedTree;
            System.out.println("Дерево успешно загружено.");
        } else {
            System.out.println("Не удалось загрузить дерево.");
        }
    }

    private void saveTreeToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String filename = scanner.nextLine();
        fileManager.saveFamilyTree(familyTree, filename);
    }

    private void searchMember() {
        // Поиск члена семьи и просмотр его родственных связей
        System.out.print("Введите ID, имя или фамилию для поиска: ");
        String searchInput = scanner.nextLine();

        if (searchInput.matches("\\d+")) { // Проверка, является ли ввод числом
            int searchId = Integer.parseInt(searchInput);
            Person personById = familyTree.getPerson(searchId);
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
            List<Person> matchedPeople;

            if (nameParts.length == 2) {
                // Если пользователь ввел и имя, и фамилию
                matchedPeople = familyTree.findByName(nameParts[0], nameParts[1]);
            } else {
                // Если введено одно слово, ищем по имени и фамилии
                matchedPeople = familyTree.findByName(searchInput, searchInput);
            }

            if (!matchedPeople.isEmpty()) {
                System.out.println("Найдены следующие члены семьи:");
                for (Person person : matchedPeople) {
                    System.out.println(person);
                }
            } else {
                System.out.println("Член семьи с таким именем или фамилией не найден.");
            }
        }
    }

    private void addNewMember() {
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
                System.out.println("Неправильный формат даты. Пожалуйста, используйте формат ГГГ-ММ-ДД.");
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

        Person newPerson = new Person(firstName, lastName, birthDate, gender);
        familyTree.addPerson(newPerson);
        System.out.println("Член семьи успешно добавлен!");

        // Установка родителей и детей
        System.out.print("Хотите добавить родителей? (да/нет): ");
        if (scanner.nextLine().equalsIgnoreCase("да")) {
            System.out.print("Введите ID матери (или -1 если неизвестно): ");
            int motherId = scanner.nextInt();
            System.out.print("Введите ID отца (или -1 если неизвестно): ");
            int fatherId = scanner.nextInt();
            scanner.nextLine();  // Очистка буфера
            familyTree.setParents(newPerson.getId(), motherId, fatherId);
            System.out.println("Родители успешно добавлены!");
        }
    }

    private void displayAllMembers() {
        // Сортировка членов семьи перед выводом
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
            for (Person person : people) {
                System.out.println(person);
            }
        }
    }
}
