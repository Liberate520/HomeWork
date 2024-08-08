import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human  father;
    private Human  mother;
    private List<Human > children;

    public Human (String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Human  getFather() {
        return father;
    }

    public void setFather(Human  father) {
        this.father = father;
    }

    public Human  getMother() {
        return mother;
    }

    public void setMother(Human  mother) {
        this.mother = mother;
    }

    public List<Human > getChildren() {
        return children;
    }

    public void addChild(Human  child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return name;
    }
}
