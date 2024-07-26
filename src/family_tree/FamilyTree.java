package family_tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс, описывающий генеалогическое дерево
public class FamilyTree {
    private Map<String, Human> humans; // Карта для хранения людей по их имени

    // Конструктор класса FamilyTree
    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    // Метод для добавления человека в дерево
    public void addHuman(String name, String birthDate) {
        humans.put(name, new Human(name, birthDate));
    }

    // Метод для получения человека по его имени
    public Human getHuman(String name) {
        return humans.get(name);
    }

    // Метод для добавления ребенка к определенному родителю
    public void addChild(String parentName, String childName) {
        Human parent = getHuman(parentName);
        Human child = getHuman(childName);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    // Метод для получения списка детей определенного человека
    public List<Human> getChildren(String parentName) {
        Human parent = getHuman(parentName);
        if (parent != null) {
            return parent.getChildren();
        }
        return null;
    }

    // Метод для отображения всего генеалогического дерева
    public void displayFamilyTree() {
        for (Human human : humans.values()) {
            System.out.println("Имя: " + human.getName() + ", Дата рождения: " + human.getBirthDate());
            List<Human> children = human.getChildren();
            if (!children.isEmpty()) {
                System.out.println("  Дети:");
                for (Human child : children) {
                    System.out.println("  - Имя: " + child.getName() + ", Дата рождения: " + child.getBirthDate());
                }
            }
        }
    }
}
