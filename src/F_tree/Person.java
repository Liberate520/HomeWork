package F_tree;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String gender) {
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

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name;
    }
}