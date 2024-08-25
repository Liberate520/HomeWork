package my_fam_tree.inf;

import my_fam_tree.model.FamilyTree;
import my_fam_tree.model.Human;
import my_fam_tree.treeService.Plant;
import my_fam_tree.treeService.FileHandler;

import java.time.LocalDate;
import java.util.Scanner;


public class InterfaceUsers {
    private FamilyTree<Human> familyTree;
    private Plant plant;
    private FileHandler fileHand;
    private Scanner scan;

    public InterfaceUsers() {
        this.familyTree = new FamilyTree<>();
        this.plant = new Plant(familyTree);
        this.fileHand = new FileHandler();
        this.scan = new Scanner(System.in, "UTF-8");
    }

    public void start() {
        while (true) {
            System.out.println("\nВыберите номер:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Найти человека");
            System.out.println("3. Показать всю семью");
            System.out.println("4. Сортировать по имени");
            System.out.println("5. Сортировать по дате рождения");
            System.out.println("6. Сохранить дерево");
            System.out.println("7. Загрузить дерево");
            System.out.println("0. Выйти");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    findHuman();
                    break;
                case 3:
                    showRelatives();
                    break;
                case 4:
                    familyTree.sortName();
                    System.out.println("Отсортировано по имени");
                    break;
                case 5:
                    familyTree.sortBirthDate();
                    System.out.println("Отсортировано по дате рождения");
                    break;
                case 6:
                    saveFile();
                    break;
                case 7:
                    loadFile();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Ошибка. Попробуйте снова.");
            }
        }
    }

    private void addHuman() {
        System.out.println("Введите имя:");
        String name = scan.nextLine();
        System.out.println("Введите пол (М/Ж):");
        String genderInput = scan.nextLine().trim().toUpperCase();
        String gender = genderInput.equals("М") ? "Мужской" : "Женский";
        System.out.println("Введите дату рождения (ГГГГ-ММ-ДД):");
        LocalDate birthDate = LocalDate.parse(scan.nextLine());

        Human human = new Human(name, gender, birthDate);
        familyTree.addRelative(human);
        System.out.println("Человек добавлен в семейное дерево.");
    }

    private void findHuman() {
        System.out.println("Введите имя для поиска:");
        String name = scan.nextLine();
        Human human = familyTree.findHuman(name);
        if (human != null) {
            System.out.println("Найдено: " + human);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private void showRelatives() {
        System.out.println("Все члены семьи:");
        for (Human human : familyTree) {
            System.out.println(human);
        }
    }

    private void saveFile() {
        System.out.println("Введите имя файла для сохранения:");
        String fileName = scan.nextLine();
        try {
            fileHand.saveToFile(fileName, (FamilyTree<?>) familyTree);
            System.out.println("Семейное дерево сохранено в файл.");
        } catch (Exception e) {
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }

    private void loadFile() {
        System.out.println("Введите имя файла для загрузки:");
        String fileName = scan.nextLine();
        try {
            familyTree = (FamilyTree<Human>) fileHand.loadFromFile(fileName);
            plant = new Plant(familyTree);
            System.out.println("Семейное дерево загружено из файла.");
        } catch (Exception e) {
            System.out.println("Ошибка при загрузке: " + e.getMessage());
        }
    }
}