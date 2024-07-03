import java.util.ArrayList;
import java.util.List;

public class Human {
    private final String name;
    private final Gender gender;
    private final int age;
    private Human spouse;
    private Human father;
    private Human mother;
    private final List<Human> children;
    // Создаем Конструктор.

    public Human(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }


}
