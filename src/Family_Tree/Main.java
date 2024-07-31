package Family_Tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Person john = new Person("John", Person.MALE, LocalDate.of(1980, 1, 1));
        Person jane = new Person("Jane", Person.FEMALE, LocalDate.of(1982, 3, 15));
        Person alice = new Person("Alice", Person.FEMALE, LocalDate.of(2010, 5, 20));

        john.addChild(alice);
        jane.addChild(alice);

        tree.addPerson(john);
        tree.addPerson(jane);
        tree.addPerson(alice);

        tree.saveToFile("family_tree.dat");

        // Загружаем данные из файла
        FamilyTree loadedTree = new FamilyTree();
        loadedTree.loadFromFile("family_tree.dat");
        System.out.println(loadedTree);
    }
}
