package service;

import familyTreeSrc.FamilyTree;
import person.Human;
import writer.FileHandler;
import writer.Writer;

import java.time.LocalDate;

import static person.Gender.Female;
import static person.Gender.Male;

//  добавил в дженерики тип Human (FamilyTree<Human>)  \\
public class Service {
    private FamilyTree<Human> familyTree;

    public Service() {
        familyTree = familyTreeTest();
    }

    public void saveTree(FamilyTree<Human> tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    public FamilyTree<Human> readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    // Метод для установки пути к файлу
    private static void setFilePath(Writer writer, String path) {
        writer.setPath(path);
    }

    // Метод для создания тестового FamilyTree
    public FamilyTree<Human> familyTreeTest() {
        // Создаем генеалогическое древо
        FamilyTree<Human> familyTree = new FamilyTree<>();

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
