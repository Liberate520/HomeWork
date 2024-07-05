package family_tree;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.read_write.FileHandler;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        FamilyTree tree = (FamilyTree) fileHandler.read();

        Map<Integer, Human> humanMap = fileHandler.readMap("humanMap.txt");
        if (humanMap == null) {
            humanMap = new TreeMap<>();
        }

        while (true) {
            menu();
            int criterion = scanner.nextInt();
            scanner.nextLine();
            if (criterion == 6) {
                System.out.println("До свидания!");
                fileHandler.write(tree);
                ((FileHandler) fileHandler).writeMap(humanMap, "humanMap.txt");
                break;
            }
            switch (criterion) {
                case 1:
                    addHumanToMap(scanner, humanMap);
                    break;
                case 2:
                    System.out.println("Укажите имя человека, которого хотите добавить:");
                    addHumanToTree(scanner, tree, humanMap);
                    break;
                case 3:
                    System.out.println("Укажите имя человека, которого хотите найти:");
                    findHuman(scanner, humanMap);
                    break;
                case 4:
                    System.out.println(tree);
                    break;
                case 5:
                    for (Human human : humanMap.values()){
                        System.out.println(human);
                    }
                    break;
            }
        }
        scanner.close();
    }

    private static void addHumanToTree(Scanner scanner, FamilyTree tree, Map<Integer, Human> humanMap) {
        String humanName = scanner.next().trim();
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : humanMap.values()) {
            if (humanName.equalsIgnoreCase(human.getName())) {
                foundHumans.add(human);
            }
        }

        if (foundHumans.isEmpty()) {
            System.out.println("Не найдено ни одного человека.");
        } else if (foundHumans.size() == 1) {
            Human foundHuman = foundHumans.get(0);
            foundHuman.setId(tree.getHumanList().size());
            tree.add(foundHuman);
            System.out.println("Человек по имени " + humanName + " был добавлен в дерево.");
        } else {
            System.out.println("Введите ID человека, которого хотите добавить в дерево:");
            for (Human foundHuman : foundHumans) {
                System.out.println(foundHuman);
            }

            while (true) {
                try {
                    int choisenId = scanner.nextInt();
                    scanner.nextLine();
                    for (Human foundHuman : foundHumans) {
                        if (foundHuman.getId() == choisenId) {
                            foundHuman.setId(tree.getHumanList().size());
                            tree.add(foundHuman);
                            System.out.println("Человек с ID + " + choisenId + " добавлен в дерево.");
                            return;
                        }
                    }
                    System.out.println("Человек с таким ID не найден.");
                    return;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ID. Пожалуйста, введите число.");
                }
            }
        }
    }

    private static void findHuman(Scanner scanner, Map<Integer, Human> humanMap) {
        String humanName = scanner.next().trim();
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : humanMap.values()) {
            if (humanName.equalsIgnoreCase(human.getName())) {
                foundHumans.add(human);
            }
        }

        if (foundHumans.isEmpty()) {
            System.out.println("Не найдено ни одного человека.");
        } else {
            for (Human foundHuman : foundHumans) {
                System.out.println(foundHuman);
            }
        }
    }

    private static void addHumanToMap(Scanner scanner, Map<Integer, Human> humanMap) {
        Human human = new Human();
        System.out.println("Введите имя человека:");
        String humanName = scanner.next().trim();
        scanner.nextLine();
        human.setName(humanName);

        System.out.println("Укажите пол человека (м/ж):");
        while (true) {
            String gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("м")) {
                human.setGender(Gender.Male);
                break;
            } else if (gender.equalsIgnoreCase("ж")) {
                human.setGender(Gender.Female);
                break;
            } else {
                System.out.println("Введен неправильный пол, попробуйте заново.");
            }
        }

        System.out.println("Введите дату рождения в формате ДД ММ ГГГГ (через пробел):");
        while (true) {
            String[] dateOfBirthArray = scanner.nextLine().trim().split(" ");
            if (dateOfBirthArray.length == 3) {
                try {
                    int year = Integer.parseInt(dateOfBirthArray[2]);
                    int month = Integer.parseInt(dateOfBirthArray[1]);
                    int day = Integer.parseInt(dateOfBirthArray[0]);
                    human.setBirthDate(LocalDate.of(year, month, day));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат даты рождения. Пожалуйста, введите числа.");
                }
            } else {
                System.out.println("Неверный формат даты рождения.");
            }
        }

        human.setId(humanMap.size());
        humanMap.put(humanMap.size(), human);
        System.out.println("Человек по имени " + humanName + " был создан.");
    }

    // Метод для будущей реализации создания нового дерева
    @SuppressWarnings("unused")
    private static void createNewTree(Scanner scanner, Map<String, FamilyTree> familyTreeMap) {
        FamilyTree tree = new FamilyTree();
        System.out.println("Введите название название нового дерева:");
        String familyTreeName = scanner.next().trim();
        familyTreeMap.put(familyTreeName, tree);
    }

    // Меню для навигации
    public static void menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Добро пожаловать в программу семейного древа. Введите цифру из меню:").append("\n");
        sb.append("1 - Создать нового человека").append("\n");
        sb.append("2 - Добавить человека в дерево").append("\n");
        sb.append("3 - Найти человека").append("\n");
        sb.append("4 - Вывести дерево в терминал").append("\n");
        sb.append("5 - Вывести всех людей в терминал").append("\n");
        sb.append("6 - Выйти из программы").append("\n");
        System.out.println(sb);
    }
}