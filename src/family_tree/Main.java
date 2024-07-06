package family_tree;

import family_tree.creators.human.Human;
import family_tree.family_tree.FamilyTree;
import family_tree.creators.Gender;
import family_tree.read_write.FileHandler;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler();
        String humanMapPath = "src/family_tree/read_write/humanMap.txt";
        String familyTreeMapPath = "src/family_tree/read_write/familyTreeMap.txt";

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
                break;
            }
            switch (criterion) {
                case 1:
                    addHumanToMap(scanner, humanMap);
                    break;
                case 2:
                    System.out.println("Укажите имя человека, которого хотите добавить:");
                    addHumanToTree(scanner, familyTreeMap, humanMap);
                    break;
                case 3:
                    System.out.println("Укажите имя человека, которого хотите найти:");
                    findHuman(scanner, humanMap);
                    break;
                case 4:
                    System.out.println("Укажите имя дерева, которого хотите найти:");
                    findFamilyTree(scanner, familyTreeMap);
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
                    addFamilyTreeToMap(scanner, familyTreeMap);
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

    private static void findFamilyTree(Scanner scanner, Map<Integer, FamilyTree> familyTreeMap) {
        String familyTreeName = scanner.next().trim();
        List<FamilyTree> foundFamilyTrees = new ArrayList<>();
        for (FamilyTree familyTree : familyTreeMap.values()) {
            if (familyTreeName.equalsIgnoreCase(familyTree.getName())) {
                foundFamilyTrees.add(familyTree);
            }
        }

        if (foundFamilyTrees.isEmpty()) {
            System.out.println("Не найдено ни одного дерево.");
        } else {
            for (FamilyTree foundFamilyTree : foundFamilyTrees) {
                System.out.println(foundFamilyTree);
            }
        }
    }

    private static void addHumanToTree(Scanner scanner, Map<Integer, FamilyTree> familyTreeMap, Map<Integer, Human> humanMap) {
        String humanName = scanner.next().trim();
        List<Human> foundHumans = new ArrayList<>();
        for (Human human : humanMap.values()) {
            if (humanName.equalsIgnoreCase(human.getName())) {
                foundHumans.add(human);
            }
        }

        System.out.println("Укажите название дерева, в которое хотите добавить человека:");
        String familyTreeName = scanner.next().trim();
        List<FamilyTree> foundFamilyTrees = new ArrayList<>();
        for (FamilyTree familyTree : familyTreeMap.values()) {
            if (familyTreeName.equalsIgnoreCase(familyTree.getName())) {
                foundFamilyTrees.add(familyTree);
            }
        }

        if (foundHumans.isEmpty() && foundFamilyTrees.isEmpty()) {
            System.out.println("Не найдено ни одного человека и дерева.");
        } else if (foundHumans.isEmpty()) {
            System.out.println("Не найдено ни одного человека.");
        } else if (foundFamilyTrees.isEmpty()) {
            System.out.println("Не найдено ни одного дерева.");
        } else if (foundHumans.size() == 1 && foundFamilyTrees.size() == 1) {
            Human foundHuman = foundHumans.get(0);
            FamilyTree foundTree = foundFamilyTrees.get(0);
            foundTree.add(foundHuman);
            System.out.println("Человек по имени " + foundHumans.get(0).getName() + " был добавлен в дерево " + foundFamilyTrees.get(0) + ".");
        } else if (foundFamilyTrees.size() > 1 && foundHumans.size() == 1) {
            for (FamilyTree foundTree : foundFamilyTrees) {
                System.out.println(foundTree);
            }
            while (true) {
                try {
                    System.out.println("Введите ID дерева в которое хотите добавить человека:");
                    int choisenId = Integer.parseInt(scanner.nextLine().trim());
                    boolean found = false;
                    for (FamilyTree foundTree : foundFamilyTrees) {
                        if (foundTree.getId() == choisenId) {
                            Human foundHuman = foundHumans.get(0);
                            foundTree.add(foundHuman);
                            System.out.println("Человек по имени " + foundHumans.get(0) + " добавлен в дерево с ID: " + foundTree.getId() + ".");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Дерево с таким ID не найдено.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ID. Пожалуйста, введите число.");
                }
            }

        } else if (foundFamilyTrees.size() == 1) {
            for (Human foundHuman : foundHumans) {
                System.out.println(foundHuman);
            }

            while (true) {
                try {
                    System.out.println("Введите ID человека, которого хотите добавить в дерево:");
                    int choisenId = Integer.parseInt(scanner.nextLine().trim());
                    boolean found = false;
                    for (Human foundHuman : foundHumans) {
                        if (foundHuman.getId() == choisenId) {
                            foundFamilyTrees.get(0).add(foundHuman);
                            System.out.println("Человек с ID " + choisenId + " добавлен в дерево " + foundFamilyTrees.get(0) + ".");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Человек с таким ID не найден.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ID. Пожалуйста, введите число.");
                }
            }
        } else {
            for (FamilyTree foundTree : foundFamilyTrees) {
                System.out.println(foundTree);
            }

            for (Human foundHuman : foundHumans) {
                System.out.println(foundHuman);
            }

            while (true) {
                try {
                    System.out.println("Введите ID дерева в которое хотите добавить человека:");
                    int choisenTreeId = Integer.parseInt(scanner.nextLine().trim());
                    System.out.println("Введите ID человека, которого хотите добавить в дерево:");
                    int choisenHumanId = Integer.parseInt(scanner.nextLine().trim());

                    boolean isTreeFound = false;
                    boolean isHumanFound = false;

                    for (FamilyTree foundTree : foundFamilyTrees) {
                        if (foundTree.getId() == choisenTreeId) {
                            for (Human foundHuman : foundHumans) {
                                if (foundHuman.getId() == choisenHumanId) {
                                    foundTree.add(foundHuman);
                                    System.out.println("Человек с ID " + choisenHumanId + " добавлен в дерево с ID " + choisenTreeId + ".");
                                    isHumanFound = true;
                                    break;
                                }
                            }
                            isTreeFound = true;
                            break;
                        }
                    }

                    if (!isTreeFound) {
                        System.out.println("Дерево с таким ID не найдено.");
                    }

                    if (!isHumanFound) {
                        System.out.println("Человек с таким ID не найден.");
                    }

                    break;
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
                    int day = Integer.parseInt(dateOfBirthArray[0]);
                    int month = Integer.parseInt(dateOfBirthArray[1]);
                    int year = Integer.parseInt(dateOfBirthArray[2]);

                    LocalDate birthDate = LocalDate.of(year, month, day);
                    LocalDate currentDate = LocalDate.now();

                    if (birthDate.isAfter(currentDate)) {
                        System.out.println("Дата рождения не может быть больше текущей даты. Пожалуйста, введите корректную дату.");
                    } else {
                        human.setBirthDate(birthDate);
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат даты рождения. Пожалуйста, введите числа.");
                } catch (DateTimeParseException e) {
                    System.out.println("Неверная дата. Пожалуйста, введите существующую дату.");
                }
            } else {
                System.out.println("Неверный формат даты рождения.");
            }
        }

        humanMap.put(human.getId(), human);
        System.out.println("Человек по имени " + humanName + " был создан.");
    }

    private static void addFamilyTreeToMap(Scanner scanner, Map<Integer, FamilyTree> familyTreeMap) {
        FamilyTree tree = new FamilyTree();
        System.out.println("Введите название нового дерева:");
        String familyTreeName = scanner.next().trim();
        tree.setName(familyTreeName);
        familyTreeMap.put(tree.getId(), tree);
        System.out.println("Дерево по имени " + familyTreeName + " было создано.");
    }
}