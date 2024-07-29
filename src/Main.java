import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        this.children.add(child);
        child.parents.add(this);
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + ", " + age + " years old";
    }
}

class FamilyTree {
    private List<Person> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addPerson(Person person) {
        this.members.add(person);
    }

    public Person findPerson(String name) {
        for (Person person : members) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    public List<Person> getChildren(String name) {
        Person person = findPerson(name);
        if (person != null) {
            return person.getChildren();
        }
        return null;
    }

    public static void main(String[] args) {
        // Создаем экземпляры класса Person
        Person john = new Person("John", 50);
        Person jane = new Person("Jane", 48);
        Person anna = new Person("Anna", 25);
        Person bob = new Person("Bob", 20);

        // Создаем семейное дерево
        FamilyTree tree = new FamilyTree();

        // Добавляем людей в семейное дерево
        tree.addPerson(john);
        tree.addPerson(jane);
        tree.addPerson(anna);
        tree.addPerson(bob);

        // Связываем родителей и детей
        john.addChild(anna);
        john.addChild(bob);
        jane.addChild(anna);
        jane.addChild(bob);

        // Проводим исследование
        List<Person> childrenOfJohn = tree.getChildren("John");
        System.out.println("Children of John: " + childrenOfJohn);
    }
}
