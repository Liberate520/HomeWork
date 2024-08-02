import family_tree.FamilyTree;
import human.Gender;
import human.Person;
import writer.FileHandler;

import java.time.LocalDate;

public class Main {
    final static String filePath = "src/writer/FamilyTree.txt";

    public static void main(String[] args) {
        FamilyTree<Person> familyTree = getFamilyTree();
        ConsoleUI consoleUI = new ConsoleUI (familyTree);
        consoleUI.start();
    }

    private static FamilyTree<Person> getFamilyTree() {
        FamilyTree<Person> familyTree = new FamilyTree<>();

        Person male_1 = new Person("Jack", 60, Gender.MALE);
        male_1.setBirthDate(LocalDate.of(1964, 6, 14));

        Person female_1 = new Person("Jane", 58, Gender.FEMALE);
        female_1.setBirthDate(LocalDate.of(1966, 6, 14));

        Person male_2 = new Person("Ted", 60, Gender.MALE);
        male_2.setBirthDate(LocalDate.of(1964, 4, 24));

        Person female_2 = new Person("Anna", 58, Gender.FEMALE);
        female_2.setBirthDate(LocalDate.of(1966, 10, 10));

        Person male_3 = new Person("Fred", 40, Gender.MALE);
        male_3.setBirthDate(LocalDate.of(1984, 5, 17));

        Person female_3 = new Person("Kate", 38, Gender.FEMALE);
        female_3.setBirthDate(LocalDate.of(1986, 2, 1));

        Person male_4 = new Person("Andrew", 20, Gender.MALE);
        male_4.setBirthDate(LocalDate.of(2004, 5, 17));

        male_1.addChild(male_3);
        female_1.addChild(male_3);

        male_2.addChild(female_3);
        female_2.addChild(female_3);

        male_3.addChild(male_4);
        female_3.addChild(male_4);

        familyTree.addElement(male_1.getName(), male_1);
        familyTree.addElement(female_1.getName(), female_1);
        familyTree.addElement(male_2.getName(), male_2);
        familyTree.addElement(female_2.getName(), female_2);
        familyTree.addElement(male_3.getName(), male_3);
        familyTree.addElement(female_3.getName(), female_3);
        familyTree.addElement(male_4.getName(), male_4);

        return familyTree;
    }

    private static FamilyTree<Person> load() {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        return (FamilyTree<Person>) fileHandler.read();
    }

    private static void save(FamilyTree<Person> familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.setPath(filePath);
        fileHandler.save(familyTree);
    }
}

