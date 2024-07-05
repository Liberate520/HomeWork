package views;

import models.Human;
import models.FamilyTree;
import models.Gender;
import presenters.Presenter;
import java.util.Scanner;

/**
 * Класс ConsoleView реализует интерфейс View и отвечает за отображение информации в консоли.
 * Он предоставляет методы для взаимодействия пользователя с приложением через консоль.
 */
public class ConsoleView implements View {
    private final Scanner scanner = new Scanner(System.in);
    private Presenter presenter;

    /**
     * Запускает приложение и начинает взаимодействие с пользователем.
     *
     * @param presenter объект презентера для обработки команд пользователя
     */
    @Override
    public void start(Presenter presenter) {
        this.presenter = presenter;
        showMainMenu();
    }

    /**
     * Отображает главное меню приложения и обрабатывает выбор пользователя.
     */
    private void showMainMenu() {
        while (true) {
            System.out.println("\nГлавное меню:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Отобразить генеалогическое древо");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по дате рождения");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Загрузить из файла");
            System.out.println("7. Выход");

            System.out.print("Введите номер пункта меню: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    displayFamilyTree();
                    break;
                case 3:
                    presenter.sortByName();
                    break;
                case 4:
                    presenter.sortByBirthDate();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    System.out.println("Выход из приложения...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    /**
     * Запрашивает у пользователя информацию о новом человеке и добавляет его в генеалогическое древо.
     */
    private void addHuman() {
        System.out.print("Введите имя нового человека: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения нового человека (дд.мм.гггг): ");
        String birthDate = scanner.nextLine();

        System.out.print("Введите дату смерти нового человека (дд.мм.гггг): ");
        String deathDate = scanner.nextLine();

        System.out.print("Введите пол нового человека (M/F): ");
        String genderInput = scanner.nextLine();
        Gender gender = genderInput.equalsIgnoreCase("M") ? Gender.MALE : Gender.FEMALE;

        Human newHuman = new Human(name, birthDate, deathDate, gender);
        presenter.addHuman(newHuman);
    }

    /**
     * Отображает генеалогическое древо в консоли в указанном порядке сортировки.
     *
     * @param familyTree генеалогическое древо для отображения
     * @param sortOrder  порядок сортировки для отображения
     */
    @Override
    public void displayFamilyTree(FamilyTree<Human> familyTree, SortOrder sortOrder) {
        switch (sortOrder) {
            case NAME:
                System.out.println("\nСортированный по имени:");
                break;
            case BIRTH_DATE:
                System.out.println("\nСортированный по дате рождения:");
                break;
            case UNSORTED:
                System.out.println("Родственные связи:");
                break;
            case LOADED:
                System.out.println("\nЗагруженные данные:");
                break;
        }
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    /**
     * Отображает сообщение об ошибке в консоли.
     *
     * @param errorMessage сообщение об ошибке
     */
    @Override
    public void displayError(String errorMessage) {
        System.out.println("Ошибка: " + errorMessage);
    }

    /**
     * Запрашивает у пользователя имя файла и сохраняет генеалогическое древо в файл.
     */
    private void saveToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String filename = scanner.nextLine();
        presenter.saveToFile(filename);
    }

    /**
     * Запрашивает у пользователя имя файла и загружает генеалогическое древо из файла.
     */
    private void loadFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String filename = scanner.nextLine();
        presenter.loadFromFile(filename);
    }
}