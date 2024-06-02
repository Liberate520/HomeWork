import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
        father.addChild(this);
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
        mother.addChild(this);
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        if (!children.contains(child)) {
            children.add(child);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
