import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для представления человека в генеалогическом древе.
 * Содержит информацию о человеке, его родителях и детях.
 */
public class Human implements Serializable {
    private String name;
    private Gender gender;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setParents(Human parent1, Human parent2) {
        parents.add(parent1);
        parents.add(parent2);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
}