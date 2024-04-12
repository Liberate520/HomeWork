import java.util.ArrayList;
import java.util.List;

public class Person {
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

public class GenealogyTree {
    private Person root;

    public GenealogyTree(Person root) {
        this.root = root;
    }

    public List<Person> getAllChildrenOfPerson(String name) {
        return findPersonByName(name).getAllChildren();
    }

    private Person findPersonByName(String name) {
        
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Иван");
        Person person2 = new Person("Алексей");
        Person person3 = new Person("Екатерина");

        person1.addChild(person2);
        person1.addChild(person3);

        GenealogyTree tree = new GenealogyTree(person1);
        List<Person> allChildren = tree.getAllChildrenOfPerson("Иван");
        for (Person child : allChildren) {
            System.out.println(child.getName());
        }
    }
}
