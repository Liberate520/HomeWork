package family_tree.model;

import java.util.ArrayList;
import java.util.List;

public class Human {
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

    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
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
