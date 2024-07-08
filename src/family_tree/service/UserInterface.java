package family_tree.service;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.writer.FileHandler;
import family_tree.writer.Writer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Service service;
    private final Scanner scanner;

    public UserInterface() {
        service = new Service();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    printAllHumans();
                    break;
                case "3":
                    sortHumansByName();
                    break;
                case "4":
                    sortHumansByDateBirth();
                    break;
                case "5":
                    findHuman();
                    break;
                case "6":
                    saveFamilyTree();
                    break;
                case "7":
                    loadFamilyTree();
                    break;
                case "0":
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
            }
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Показать всех людей");
        System.out.println("3. Сортировать людей по имени");
        System.out.println("4. Сортировать людей по дате рождения");
        System.out.println("5. Найти человека");
        System.out.println("6. Сохранить семейное дерево");
        System.out.println("7. Загрузить семейное дерево");
        System.out.println("0. Выход");
        System.out.print("Введите команду: ");
    }

    private void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        Human human = service.addHuman(name, dob, gender);
        System.out.println("Человек добавлен: " + human);
    }

    private void printAllHumans() {
        System.out.println(service.getHumanListInfo());
    }

    private void sortHumansByName() {
        service.sortByName();
        System.out.println("Отсортированный список людей по имени.");

    }

    private void sortHumansByDateBirth() {
        service.sortByDateBirth();
        System.out.println("Люди отсортированы по дате рождения.");
    }

    private void findHuman() {
        System.out.print("Введите имя или ID для поиска: ");
        String searchInput = scanner.nextLine();

        try {
            int searchId = Integer.parseInt(searchInput);
            Human foundHuman = service.findHumanById(searchId);
            if (foundHuman != null) {
                System.out.println("Найденный человек по ID:");
                System.out.println(foundHuman);
            } else {
                System.out.println("Человек с ID " + searchId + " не найден.");
            }
        } catch (NumberFormatException e) {
            List<Human> foundHumans = service.findHumansByName(searchInput);
            if (!foundHumans.isEmpty()) {
                System.out.println("Найденные люди по имени:");
                for (Human human : foundHumans) {
                    System.out.println(human);
                }
            } else {
                System.out.println("Человек с именем " + searchInput + " не найден.");
            }
        }
    }

    private void saveFamilyTree() {
        Writer fileWriter = new FileHandler();
        try {
            fileWriter.save(service.getFamilyTree());
            System.out.println("Семейное дерево сохранено в файл: " + FileHandler.getFilePath());
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
        }
    }

    private void loadFamilyTree() {
        Writer fileWriter = new FileHandler();
        try {
            service.setFamilyTree(fileWriter.load());
            System.out.println("Семейное дерево загружено из файла: " + FileHandler.getFilePath());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке из файла: " + e.getMessage());
        }
    }
}
