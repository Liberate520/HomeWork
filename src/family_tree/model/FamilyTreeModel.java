package family_tree.model;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;
import java.io.Serializable;
import family_tree.view.ConsoleFamilyTreeView;


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


}