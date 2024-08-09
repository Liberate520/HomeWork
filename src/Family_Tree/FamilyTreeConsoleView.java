package Family_Tree;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Scanner;

public class FamilyTreeConsoleView {
    private final FamilyTreePresenter presenter;
    private final Scanner scanner;

    public FamilyTreeConsoleView(FamilyTreePresenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Добро пожаловать в консоль Семейного Дерева");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    addAnimal();
                    break;
                case 4:
                    findAnimal();
                    break;
                case 5:
                    saveTreeToFile();
                    break;
                case 6:
                    loadTreeFromFile();
                    break;
                case 7:
                    displayTree();
                    break;
                case 8:
                    System.out.println("Выход...");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
            }
        }
    }

    public void displayMenu() {
        System.out.println("1. Добавить человека");
        System.out.println("2. Найти человека");
        System.out.println("3. Добавить животное");
        System.out.println("4. Найти животное");
        System.out.println("5. Сохранить Семейное Дерево в файл");
        System.out.println("6. Загрузить Семейное Дерево из файла");
        System.out.println("7. Отобразить Семейное Дерево");
        System.out.println("8. Выход");
        System.out.print("Введите Ваш выбор: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // потребление символа новой строки
        return choice;
    }

    private void addPerson() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (0 для Мужского, 1 для Женского): ");
        int gender = scanner.nextInt();
        scanner.nextLine(); // потребление символа новой строки
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        presenter.addPerson(name, "", gender, birthDate);
    }

    private void findPerson() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Person person = presenter.findPersonByName(name, "");
        if (person != null) {
            System.out.println("Человек найден:");
            System.out.println(person);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private void addAnimal() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите породу: ");
        String breed = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        presenter.addAnimal(name, breed, birthDate);
    }

    private void findAnimal() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        Animal animal = presenter.findAnimalByName(name);
        if (animal != null) {
            System.out.println("Животное найдено:");
            System.out.println(animal);
        } else {
            System.out.println("Животное не найдено.");
        }
    }

    private void saveTreeToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine();
        presenter.saveToFile(fileName);
    }

    private void loadTreeFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine();
        presenter.loadFromFile(fileName);
    }

    private void displayTree() {
        System.out.println("Семейное Дерево:");
        System.out.println("Люди:");
        for (Person person : presenter.getPeople()) {
            System.out.println(person);
        }
        System.out.println("Животные:");
        for (Animal animal : presenter.getAnimals()) {
            System.out.println(animal);
        }
    }

    public void displayPersonAdded(Person person) {
        System.out.println("Человек успешно добавлен: " + person);
    }

    public void displayAnimalAdded(Animal animal) {
        System.out.println("Животное успешно добавлено: " + animal);
    }

    public void displayFileSaved(String fileName) {
        System.out.println("Семейное Дерево сохранено в файл: " + fileName);
    }

    public void displayFileLoaded(String fileName) {
        System.out.println("Семейное Дерево загружено из файла: " + fileName);
    }
}

