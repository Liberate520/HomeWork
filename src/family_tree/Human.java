package family_tree;

import java.util.ArrayList;
import java.util.List;

// Класс, описывающий человека в генеалогическом дереве
public class Human {
    private String name; // Имя человека
    private String birthDate; // Дата рождения
    private List<Human> children; // Список детей этого человека

    // Конструктор класса Human
    public Human(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для получения даты рождения
    public String getBirthDate() {
        return birthDate;
    }

    // Метод для получения списка детей
    public List<Human> getChildren() {
        return children;
    }

    // Метод для добавления ребенка к этому человеку
    public void addChild(Human child) {
        this.children.add(child);
    }
}

