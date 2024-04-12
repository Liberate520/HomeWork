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

public class GenealogyTree implements java.io.Serializable {
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

        FileHandler fileHandler = new FileHandler();

        try {
            fileHandler.serialize("genealogy_tree.dat", tree);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            GenealogyTree loadedTree = (GenealogyTree) fileHandler.deserialize("genealogy_tree.dat");
            // Используем загруженное древо
            List<Person> allChildren = loadedTree.getAllChildrenOfPerson("Иван");
            for (Person child : allChildren) {
                System.out.println(child.getName());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
