package family_tree;

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String gender;
    private List<Human> children;

    public Human(String name, String gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name + " (" + gender + ")";
    }
}
