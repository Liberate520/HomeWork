package family_tree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
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

    // Геттеры и сеттеры для полей

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

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
