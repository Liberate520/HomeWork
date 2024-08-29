package Homework4_OOP.WritersClasses;

import Homework4_OOP.Human.Gender;
import Homework4_OOP.Human.Human;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void printMenu() {
        System.out.println("1- Добавить человека");
        System.out.println("2- Поиск по имени");
        System.out.println("3- Удаление по ID");
        System.out.println("4- Вывод Древа");
        System.out.println("5- Создание родственной связи (родитель-ребенок)");
        System.out.println("6- Установить брак");  // Новая опция для установления брака
        System.out.println("7- Сохранить древо");
        System.out.println("8- Загрузить древо");
        System.out.println("9- Выход");
        System.out.print("Выберите из предложенного: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }
    public long getFirstSpouseId() {
        System.out.print("Введите ID первого супруга: ");
        return scanner.nextLong();
    }

    public long getSecondSpouseId() {
        System.out.print("Введите ID второго супруга: ");
        return scanner.nextLong();
    }

    public void printWeddingResult(boolean success) {
        if (success) {
            System.out.println("Брак успешно зарегистрирован.");
        } else {
            System.out.println("Ошибка при установлении брака. Возможно, один из супругов уже состоит в браке.");
        }
    }
    public Human getHumanDetails() {
        scanner.nextLine(); // Consume newline
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Выберете пол человека (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.print("Введите дату рождения (yyyy-mm-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        return new Human(name, gender, birthDate);
    }

    public String getSearchName() {
        System.out.print("Введите имя для поиска: ");
        return scanner.nextLine();
    }

    public void printSearchResults(List<Human> results) {
        if (results.isEmpty()) {
            System.out.println("Человека с таким именем не найдено.");
        } else {
            results.forEach(System.out::println);
        }
    }

    public long getIdToRemove() {
        System.out.print("Введите ID для удаления: ");
        return scanner.nextLong();
    }

    public void printRemoveResult(boolean result) {
        if (result) {
            System.out.println("Человек успешно удален.");
        } else {
            System.out.println("Ошибка: человек с таким ID не найден.");
        }
    }

    public long getParentId() {
        System.out.print("Введите ID родителя: ");
        return scanner.nextLong();
    }

    public long getChildId() {
        System.out.print("Введите ID ребенка: ");
        return scanner.nextLong();
    }

    public void printFamilyRelationshipCreatedMessage() {
        System.out.println("Родственная связь успешно создана.");
    }

    public String getFilenameToSave() {
        System.out.print("Введите имя файла для сохранения: ");
        scanner.nextLine(); // Consume newline
        return scanner.nextLine();
    }

    public void printSaveResult(boolean success) {
        if (success) {
            System.out.println("Древо успешно сохранено.");
        } else {
            System.out.println("Ошибка при сохранении древа.");
        }
    }

    public String getFilenameToLoad() {
        System.out.print("Введите имя файла для загрузки: ");
        scanner.nextLine(); // Consume newline
        return scanner.nextLine();
    }

    public void printLoadResult(boolean success) {
        if (success) {
            System.out.println("Древо успешно загружено.");
        } else {
            System.out.println("Ошибка при загрузке древа.");
        }
    }

    public void printTree(String treeInfo) {
        System.out.println(treeInfo);
    }

    public void exitMessage() {
        System.out.println("Завершение работы...");
    }

    public void printInvalidChoiceMessage() {
        System.out.println("Неверный выбор, попробуйте снова.");
    }

    public void printHumanAddedMessage() {
        System.out.println("Человек успешно добавлен.");
    }
}
