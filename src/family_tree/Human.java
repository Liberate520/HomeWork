package familly_tree;

import java.util.ArrayList;
import java.util.List;

class Human {
    private String name;
    private String gender;
    private String birthDate;
    private String deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String name, String gender, String birthDate, String deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Добавить ребенка
    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this); // добавляем текущего человека в список родителей ребенка
    }

    // Добавить родителя
    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    // Дополнительные геттеры и сеттеры
    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }
}
