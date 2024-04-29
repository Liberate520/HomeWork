package family_tree.model;


import java.util.Comparator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.io.Serializable;

import family_tree.view.ConsoleFamilyTreeView;

import java.io.IOException;


public class FamilyTreeModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Human familyTreeRoot;
    private List<Human> familyMembers;

    public FamilyTreeModel() {
        this.familyTreeRoot = null;
        this.familyMembers = new ArrayList<>();
    }

    public void addBeing(Human being) {
        // Генерация уникального ID для человека
        String uniqueId = generateUniqueId();

        // Установка уникального ID для добавляемого человека
        being.setId(uniqueId);

        if (familyTreeRoot == null) {
            familyTreeRoot = being;
        } else {
            // Проверяем, есть ли у человека родители
            if (!being.getParents().isEmpty()) {
                for (Human parent : being.getParents()) {
                    // Проверяем, добавлен ли уже родитель к ребенку
                    if (!parent.getChildren().contains(being)) {
                        parent.addChild(being);
                    }
                }
            }

            // Проверяем, есть ли у человека дети
            if (!being.getChildren().isEmpty()) {
                for (Human child : being.getChildren()) {
                    // Проверяем, добавлен ли уже ребенок к родителю
                    if (!being.getChildren().contains(child)) {
                        being.addChild(child);
                    }
                }
            }
        }
        this.familyMembers.add(being);
    }

    public List<Human> getSortedTree() {
        List<Human> sortedTree = new ArrayList<>(familyMembers);
        sortedTree.sort(Comparator.comparing(Human::getName));
        return sortedTree;
    }

    public List<Human> getUnsortedTree() {
        return familyMembers;
    }

    public List<Human> getSortedTreeByBirthDate() {
        List<Human> sortedTree = new ArrayList<>(familyMembers);
        sortedTree.sort(Comparator.comparing(Human::getBirthDate));
        return sortedTree;
    }

    public Human findBeing(String name) {
        for (Human being : familyMembers) {
            if (being.getName().equalsIgnoreCase(name)) {
                return being;
            }
        }
        return null;
    }

    private String generateUniqueId() {
        // Используем текущее время в миллисекундах в качестве уникального идентификатора
        return String.valueOf(System.currentTimeMillis());
    }

    public void addNewPerson(Scanner scanner, ConsoleFamilyTreeView view) {
        System.out.print("Введите имя нового человека: ");
        String newName = scanner.nextLine();
        System.out.print("Введите пол нового человека: ");
        String newGender = scanner.nextLine();
        System.out.print("Введите дату рождения нового человека в формате день-месяц-год: ");
        String newBirthDate = scanner.nextLine();
        System.out.print("Введите дату смерти нового человека в формате день-месяц-год (оставьте пустым если нет информации): ");
        String newDeathDate = scanner.nextLine();
        Human newPerson = new Human(newName, newGender, newBirthDate, newDeathDate);
        System.out.print("Введите имена родителей через запятую (если есть): ");
        String parentsInput = scanner.nextLine();
        if (!parentsInput.isEmpty()) {
            String[] parentNames = parentsInput.split(",");
            for (String parentName : parentNames) {
                Human parent = findBeing(parentName.trim()); // Используем метод findBeing() текущего объекта
                if (parent != null) {
                    parent.addChild(newPerson);
                    newPerson.addParent(parent);
                } else {
                    System.out.println("Человек с именем " + parentName + " не найден.");
                }
            }
        }
        System.out.print("Введите имена детей через запятую (если есть): ");
        String childrenInput = scanner.nextLine();
        if (!childrenInput.isEmpty()) {
            String[] childrenNames = childrenInput.split(",");
            for (String childName : childrenNames) {
                Human child = findBeing(childName.trim()); // Используем метод findBeing() текущего объекта
                if (child != null) {
                    newPerson.addChild(child);
                    child.addParent(newPerson);
                } else {
                    System.out.println("Человек с именем " + childName + " не найден.");
                }
            }
        }

        addBeing(newPerson);
    }

}
