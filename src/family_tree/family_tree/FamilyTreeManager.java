package family_tree.family_tree;

import family_tree.interfaces.Addable;
import family_tree.interfaces.Identifiable;
import family_tree.interfaces.Nameable;
import family_tree.creators.Gender;
import family_tree.creators.human.Human;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FamilyTreeManager<T extends Nameable & Addable<T>> {
    public void addHumanToTree(Scanner scanner, Map<Integer, T> familyTreeMap, Map<Integer, T> humanMap) {
        List<T> foundHumans = findEntities(scanner, humanMap, "Введите имя человека:");
        if (foundHumans.isEmpty()) {
            System.out.println("Не найдено ни одного человека.");
            return;
        }

        List<T> foundFamilyTrees = findEntities(scanner, familyTreeMap, "Укажите название дерева, в которое хотите добавить человека:");
        if (foundFamilyTrees.isEmpty()) {
            System.out.println("Не найдено ни одного дерева.");
            return;
        }

        T selectedHuman = selectEntity(scanner, foundHumans, "Введите ID человека, которого хотите добавить в дерево:");
        T selectedTree = selectEntity(scanner, foundFamilyTrees, "Введите ID дерева, в которое хотите добавить человека:");

        if (selectedHuman != null && selectedTree != null) {
            selectedTree.add(selectedHuman);
            System.out.println("Человек по имени " + selectedHuman.getName() + " добавлен в дерево " + selectedTree.getName() + ".");
        }
    }

    public void findEntity(Scanner scanner, Map<Integer, T> entityTreeMap, String message1, String message2) {
        List<T> foundEntities = findEntities(scanner, entityTreeMap, message1);
        if (foundEntities.isEmpty()) {
            System.out.println(message2);
        } else {
            for (T foundEntity : foundEntities) {
                System.out.println(foundEntity);
            }
        }
    }

    public void addHumanToMap(Scanner scanner, Map<Integer, Human> humanMap) {
        Human human = new Human();
        System.out.println("Введите имя человека:");
        String humanName = scanner.next().trim();
        human.setName(humanName);

        System.out.println("Укажите пол человека (м/ж):");
        human.setGender(getGenderFromInput(scanner));

        System.out.println("Введите дату рождения в формате ДД ММ ГГГГ (через пробел):");
        human.setBirthDate(getBirthDateFromInput(scanner));

        humanMap.put(human.getId(), human);
        System.out.println("Человек по имени " + humanName + " был создан.");
    }

    public void addFamilyTreeToMap(Scanner scanner, Map<Integer, FamilyTree> familyTreeMap) {
        FamilyTree tree = new FamilyTree();
        System.out.println("Введите название нового дерева:");
        String familyTreeName = scanner.next().trim();
        tree.setName(familyTreeName);

        familyTreeMap.put(tree.getId(), tree);
        System.out.println("Дерево по имени " + familyTreeName + " было создано.");
    }

    private List<T> findEntities(Scanner scanner, Map<Integer, T> entitiesMap, String message) {
        System.out.println(message);
        String entityName = scanner.next().trim();
        List<T> foundEntities = new ArrayList<T>();
        for (T entity : entitiesMap.values()) {
            if (entityName.equalsIgnoreCase(entity.getName())) {
                foundEntities.add(entity);
            }
        }
        return foundEntities;
    }

    private T selectEntity(Scanner scanner, List<T> foundEntities, String message) {
        if (foundEntities.size() == 1) {
            return foundEntities.get(0);
        } else {
            for (T foundEntity : foundEntities) {
                System.out.println(foundEntity);
            }
            return selectById(scanner, foundEntities, message);
        }
    }

    private Gender getGenderFromInput(Scanner scanner) {
        while (true) {
            String gender = scanner.next().trim();
            scanner.nextLine();
            if (gender.equalsIgnoreCase("м")) {
                return Gender.Male;
            } else if (gender.equalsIgnoreCase("ж")) {
                return Gender.Female;
            } else {
                System.out.println("Введен неправильный пол, попробуйте заново.");
            }
        }
    }

    private LocalDate getBirthDateFromInput(Scanner scanner) {
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
                        return birthDate;
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
    }

    private <U> U selectById(Scanner scanner, List<U> list, String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                int chosenId = Integer.parseInt(scanner.next().trim());
                scanner.nextLine();
                for (U item : list) {
                    if (item instanceof Identifiable && ((Identifiable) item).getId() == chosenId) {
                        return item;
                    }
                }
                System.out.println("Элемент с таким ID не найден.");
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ID. Пожалуйста, введите число.");
            }
        }
    }
}
