package familytree;

import familytree.model.FamilyTree;
import familytree.model.Gender;
import familytree.model.Person;
import familytree.service.FileHandler;
import familytree.service.Research;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person john = new Person("John", LocalDate.of(1980, 6, 15), Gender.MALE);
        Person mary = new Person("Mary", LocalDate.of(1982, 3, 20), Gender.FEMALE);
        Person peter = new Person("Peter", LocalDate.of(2010, 1, 10), Gender.MALE);
        Person sarah = new Person("Sarah", LocalDate.of(2012, 8, 5), Gender.FEMALE);

        john.addChild(peter);
        john.addChild(sarah);
        mary.addChild(peter);
        mary.addChild(sarah);

        familyTree.addPerson(john);
        familyTree.addPerson(mary);
        familyTree.addPerson(peter);
        familyTree.addPerson(sarah);

        System.out.println("John's children:");
        List<Person> johnsChildren = Research.findChildren(john);
        for (Person child : johnsChildren) {
            System.out.println(child.getName());
        }

        FileHandler fileHandler = new FileHandler();
        try {
            fileHandler.save(familyTree, "family_tree.dat");
            System.out.println("Family tree saved successfully.");

            FamilyTree loadedTree = fileHandler.load("family_tree.dat");
            System.out.println("Family tree loaded successfully.");

            System.out.println("Sorted by name:");
            loadedTree.sortByName();
            for (Person person : loadedTree) {
                System.out.println(person.getName());
            }

            System.out.println("Sorted by birth date:");
            loadedTree.sortByBirthDate();
            for (Person person : loadedTree) {
                System.out.println(person.getName() + " - " + person.getBirthDate());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
