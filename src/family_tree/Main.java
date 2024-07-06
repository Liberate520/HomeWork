package family_tree;

import family_tree.creators.IDGenerator;
import family_tree.creators.human.Human;
import family_tree.family_tree.FamilyTree;
import family_tree.family_tree.FamilyTreeManager;
import family_tree.read_write.FileHandler;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        FamilyTreeManager familyTreeManager = new FamilyTreeManager();

        String humanMapPath = "src/family_tree/read_write/serialized_files/humanMap.ser";
        String familyTreeMapPath = "src/family_tree/read_write/serialized_files/familyTreeMap.ser";

        Map<Integer, Human> humanMap = fileHandler.readMap(humanMapPath);
        if (humanMap == null) {
            humanMap = new TreeMap<>();
        }

        Map<Integer, FamilyTree> familyTreeMap = fileHandler.readMap(familyTreeMapPath);
        if (familyTreeMap == null) {
            familyTreeMap = new TreeMap<>();
        }

        while (true) {
            menu();
            int criterion = scanner.nextInt();
            scanner.nextLine();
            if (criterion == 8) {
                System.out.println("До свидания!");
                ((FileHandler) fileHandler).writeMap(humanMap, humanMapPath);
                ((FileHandler) fileHandler).writeMap(familyTreeMap, familyTreeMapPath);
                Runtime.getRuntime().addShutdownHook(new Thread(() -> IDGenerator.saveCounter()));
                break;
            }
            switch (criterion) {
                case 1:
                    familyTreeManager.addHumanToMap(scanner, humanMap);
                    break;
                case 2:
                    System.out.println("Укажите имя человека, которого хотите добавить:");
                    familyTreeManager.addHumanToTree(scanner, familyTreeMap, humanMap);
                    break;
                case 3:
                    System.out.println("Укажите имя человека, которого хотите найти:");
                    familyTreeManager.findHuman(scanner, humanMap);
                    break;
                case 4:
                    System.out.println("Укажите имя дерева, которого хотите найти:");
                    familyTreeManager.findFamilyTree(scanner, familyTreeMap);
                    break;
                case 5:
                    for (Human human : humanMap.values()) {
                        System.out.println(human);
                    }
                    break;
                case 6:
                    for (FamilyTree familyTree : familyTreeMap.values()) {
                        System.out.println(familyTree);
                    }
                    break;
                case 7:
                    familyTreeManager.addFamilyTreeToMap(scanner, familyTreeMap);
                    break;
            }
        }
        scanner.close();
    }

    // Меню для навигации
    public static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Добро пожаловать в программу семейного древа. Введите цифру из меню:").append("\n");
        sb.append("1 - Создать нового человека").append("\n");
        sb.append("2 - Добавить человека в дерево").append("\n");
        sb.append("3 - Найти человека").append("\n");
        sb.append("4 - Найти дерево").append("\n");
        sb.append("5 - Вывести всех людей в терминал").append("\n");
        sb.append("6 - Вывести все деревья в терминал").append("\n");
        sb.append("7 - Создать новое дерево").append("\n");
        sb.append("8 - Выйти из программы").append("\n");
        System.out.println(sb);
    }
}