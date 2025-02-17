package Homework6_OOP.WritersClasses;

import Homework6_OOP.Human.Gender;
import Homework6_OOP.Human.Human;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("1 - Добавить человека");
        System.out.println("2 - Поиск по имени");
        System.out.println("3 - Удаление по ID");
        System.out.println("4 - Показать семейное дерево");
        System.out.println("5 - Создать родственную связь (родитель-ребенок)");
        System.out.println("6 - Создать брак");
        System.out.println("7 - Сохранить семейное дерево");
        System.out.println("8 - Загрузить семейное дерево");
        System.out.println("9 - Выход");
        System.out.print("Выберите действие: ");
    }

    public int getUserChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.print("Введите число: ");
                scanner.next();
            }
        }
    }

    public Human getHumanDetails() {
        scanner.nextLine();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();

        System.out.print("Введите пол (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());

        System.out.print("Введите дату рождения (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        return new Human(name, gender, birthDate);
    }

    public String getSearchQuery() {
        scanner.nextLine();
        System.out.print("Введите имя для поиска: ");
        return scanner.nextLine();
    }
    public void printRelationshipFailureMessage() {
        System.out.println("Failed to establish relationship: ");
    }
    public void printSearchResults(List<Human> results) {
        if (results.isEmpty()) {
            printNoResultsMessage();
        } else {
            System.out.println("Результаты поиска:");
            for (Human human : results) {
                System.out.println(human);
            }
        }
    }

    public long getId() {
        System.out.print("Введите ID: ");
        return scanner.nextLong();
    }

    public long getParentId() {
        System.out.print("Введите ID родителя: ");
        return scanner.nextLong();
    }

    public long getChildId() {
        System.out.print("Введите ID ребенка: ");
        return scanner.nextLong();
    }

    public long getId1() {
        System.out.print("Введите ID первого человека: ");
        return scanner.nextLong();
    }

    public long getId2() {
        System.out.print("Введите ID второго человека: ");
        return scanner.nextLong();
    }

    public String getFilename() {
        scanner.nextLine();
        System.out.print("Введите имя файла: ");
        return scanner.nextLine();
    }

    public void printFamilyTree(String treeInfo) {
        System.out.println("Семейное дерево:");
        System.out.println(treeInfo);
    }

    public void printHumanAddedMessage() {
        System.out.println("Человек успешно добавлен.");
    }

    public void printHumanRemovedMessage() {
        System.out.println("Человек успешно удален.");
    }

    public void printHumanNotFoundMessage() {
        System.out.println("Человек не найден.");
    }

    public void printRelationshipCreatedMessage() {
        System.out.println("Родственная связь успешно создана.");
    }

    public void printWeddingSuccessMessage() {
        System.out.println("Брак успешно зарегистрирован.");
    }

    public void printWeddingFailureMessage() {
        System.out.println("Ошибка: невозможно зарегистрировать брак.");
    }

    public void printSaveSuccessMessage() {
        System.out.println("Семейное дерево успешно сохранено.");
    }

    public void printSaveFailureMessage() {
        System.out.println("Ошибка при сохранении семейного дерева.");
    }

    public void printLoadSuccessMessage() {
        System.out.println("Семейное дерево успешно загружено.");
    }

    public void printLoadFailureMessage() {
        System.out.println("Ошибка при загрузке семейного дерева.");
    }

    public void printNoResultsMessage() {
        System.out.println("Результатов не найдено.");
    }

    public void exitMessage() {
        System.out.println("Завершение работы...");
    }

    public void printInvalidChoiceMessage() {
        System.out.println("Неверный выбор, попробуйте снова.");
    }
}
