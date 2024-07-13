import familyTreeSrc.FamilyTree;
import person.Human;
import person.Gender;
import writer.FileHandler;

import java.io.Serializable;
import java.time.LocalDate;

import static person.Gender.Female;
import static person.Gender.Male;

public class Main {
    public static void main(String[] args) {
        //FamilyTree tree = familyTreeTest();
        FamilyTree tree = readTree();

        saveTree(tree);

        System.out.println(tree);
    }

    private static void saveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static FamilyTree familyTreeTest() {
        // Создаем генеалогическое древо
        FamilyTree familyTree = new FamilyTree();

        // Создаем родителей без указания их родителей
        Human harry = new Human("Harry", Male, LocalDate.of(1941, 2, 22), LocalDate.of(2018, 11, 16));
        Human emily = new Human("Emily", Female, LocalDate.of(1946, 6, 10), LocalDate.of(2023, 2, 5));

        familyTree.addHuman(harry);
        familyTree.addHuman(emily);
        familyTree.setWedding(harry, emily);

        Human charlie = new Human("Charlie", Male, LocalDate.of(1944, 1, 8), LocalDate.of(2020, 12, 4));
        Human ella = new Human("Ella", Female, LocalDate.of(1952, 10, 17));

        familyTree.addHuman(charlie);
        familyTree.addHuman(ella);
        familyTree.setWedding(charlie, ella);

        // Создаем детей, указывая их родителей
        Human james = new Human("James", Male, LocalDate.of(1985, 7, 30), harry, emily);
        Human jane = new Human("Jane", Female, LocalDate.of(1990, 8, 2), charlie, ella);

        familyTree.addHuman(james);
        familyTree.addHuman(jane);
        familyTree.setWedding(james, jane);

        // Создаем детей, указывая их родителей
        Human emma = new Human("Emma", Female, LocalDate.of(2018, 3, 3), james, jane);
        Human michael  = new Human("Michael", Male, LocalDate.of(2016, 1, 19), james, jane);
        Human thomas  = new Human("Thomas", Male, LocalDate.of(2020, 4, 19), james, jane);

        familyTree.addHuman(emma);
        familyTree.addHuman(michael);
        familyTree.addHuman(thomas);

        return familyTree;
    }
}
