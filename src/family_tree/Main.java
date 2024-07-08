package family_tree;

import family_tree.creators.Gender;
import family_tree.creators.IDGenerator;
import family_tree.creators.human.Human;
import family_tree.family_tree.FamilyTree;
import family_tree.family_tree.FamilyTreeManager;
import family_tree.read_write.FileHandler;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> ft = new FamilyTree<>();
        Human azer = new Human("Azer", Gender.Male, LocalDate.of(1995, 5, 3));
        Human azer1 = new Human("Elvin", Gender.Female, LocalDate.of(1999, 5, 3));
        Human azer2 = new Human("Anar", Gender.Male, LocalDate.of(1997, 5, 3));
        Human azer3 = new Human("Samir", Gender.Male, LocalDate.of(1998, 5, 3));
        Human azer4 = new Human("Azer", Gender.Female, LocalDate.of(1993, 5, 3));
        Human azer5 = new Human("Ali", Gender.Male, LocalDate.of(2000, 5, 3));

        ft.add(azer);
        ft.add(azer1);
        ft.add(azer2);
        ft.add(azer3);
        ft.add(azer4);
        ft.add(azer5);

        System.out.println(ft.getCreatorsListInfo());
        ft.sortByName();
        System.out.println(ft.getCreatorsListInfo());
        ft.sortByAge();
        System.out.println(ft.getCreatorsListInfo());








        /*Scanner scanner = new Scanner(System.in);
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
                    familyTreeManager.addHumanToTree(scanner, familyTreeMap, humanMap);
                    break;
                case 3:
                    System.out.println();
                    familyTreeManager.findEntity(scanner, humanMap, "Укажите имя человека, которого хотите найти:", "Не найдено ни одного чнловека");
                    break;
                case 4:
                    System.out.println();
                    familyTreeManager.findEntity(scanner, familyTreeMap, "Укажите название дерева, которого хотите найти:", "Не найдено ни одно дерево");
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
        scanner.close();*/
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