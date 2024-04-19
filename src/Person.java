import java.util.ArrayList;
import java.util.List;

public class Person implements java.io.Serializable {
    private String name;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public List<Person> getAllChildren() {
        List<Person> allChildren = new ArrayList<>();
        for (Person child : this.children) {
            allChildren.add(child);
            allChildren.addAll(child.getAllChildren());
        }
        return allChildren;
    }

    public String getName() {
        return name;
    }
}
