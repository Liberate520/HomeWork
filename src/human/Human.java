package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tree_node.TreeNode;

public class Human implements TreeNode<Human>, Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private Gender gender;
    private int age;
    private LocalDate birthDate;
    private Human spouse;
    private Human father;
    private Human mother;
    private final List<Human> children;

    public Human(String name, Gender gender, int age, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public Human getParent() {
        if (father != null) {
            return father;
        } else {
            return mother;
        }
    }

    @Override
    public void setParent(Human parent) {
        if (parent.getGender() == Gender.MALE) {
            this.father = parent;
        } else {
            this.mother = parent;
        }
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
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
}