import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final Gender gender;
    private final List<Person> children;

    public Person(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setFather() {
    }

    public void setMother() {
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}


