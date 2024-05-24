package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Node father;
    private Node mother;
    private List<Node> children;
    private Node spouse;

    public Node(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Node father, Node mother) {
        this.id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Node(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public void addChild(Node child) {
        if (!children.contains(child)) {
            children.add(child);
            if (this.gender == Gender.Male) {
                child.setFather(this);
            } else if (this.gender == Gender.Female) {
                child.setMother(this);
            }
        }
    }

    public int getAge() {
        if (deathDate == null) {
            return Period.between(birthDate, LocalDate.now()).getYears();
        } else {
            return Period.between(birthDate, deathDate).getYears();
        }
    }

    public void setSpouse(Node spouse) {
        this.spouse = spouse;
        if (spouse != null && spouse.getSpouse() != this) {
            spouse.setSpouse(this);
        }
    }

    public Node getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Node getFather() {
        return father;
    }

    public void setFather(Node father) {
        this.father = father;
    }

    public Node getMother() {
        return mother;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    public List<Node> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(", имя: ").append(name);
        sb.append(", пол: ").append(gender);
        sb.append(", возраст: ").append(getAge());
        sb.append(", супруг(а): ").append(spouse != null ? spouse.getName() : "нет");
        sb.append(", мать: ").append(mother != null ? mother.getName() : "неизвестна");
        sb.append(", отец: ").append(father != null ? father.getName() : "неизвестен");
        sb.append(", дети: ");
        if (!children.isEmpty()) {
            for (Node child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        } else {
            sb.append("отсутствуют");
        }
        return sb.toString();
    }
}
