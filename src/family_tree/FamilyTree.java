package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Класс, описывающий генеалогическое дерево
public class FamilyTree implements Serializable {
    private static final long serialVersionUID = 1L; // Для обеспечения совместимости версий

    private Map<String, Human> humans; // Карта для хранения людей по их имени

    // Конструктор класса FamilyTree
    public FamilyTree() {
        this.humans = new HashMap<>();
    }

    // Метод для добавления человека в дерево
    public void addHuman(String name, String birthDate, String gender) {
        humans.put(name, new Human(name, birthDate, gender));
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
            child.addParent(parent); // Добавление родителя к ребенку
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

    // Метод для установки даты смерти
    public void setDeathDate(String name, String deathDate) {
        Human human = getHuman(name);
        if (human != null) {
            human.setDeathDate(deathDate);
        }
    }

    // Метод для установки супружеской связи
    public void setSpouse(String name1, String name2) {
        Human human1 = getHuman(name1);
        Human human2 = getHuman(name2);
        if (human1 != null && human2 != null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1); // Устанавливаем связь в обе стороны
        }
    }

    // Метод для отображения всего генеалогического дерева
    public String displayFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humans.values()) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    // Метод для получения всех людей в дереве
    public List<Human> getAllHumans() {
        return new ArrayList<>(humans.values());
    }
}

