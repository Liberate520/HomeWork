import java.util.ArrayList;
import java.util.List;


class Person {
    private String name;
    private int age;
    private Person mother;
    private Person father;
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

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
        if (this instanceof Male) {
            child.setFather(this);
        } else if (this instanceof Female) {
            child.setMother(this);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}