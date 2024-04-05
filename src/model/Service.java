package model;

import model.entity.Gender;
import model.entity.Person;
import model.tree.FamilyTree;
import model.tree.FamilyTreeEntity;
import model.writer.FileHandler;

import java.time.LocalDate;

public class Service {

    private FamilyTree<Person> familyTree;
    private FileHandler fh = new FileHandler();

    public Service() {
        this.familyTree = new FamilyTree();

    }

    public FamilyTree<Person> prep() {

        // Добавляем людей в дерево
        Person person1 = new Person("John", Gender.Male, LocalDate.of(1950, 05, 30));
        Person person2 = new Person("Jane", Gender.Female, LocalDate.of(1952, 02, 15));
        Person person3 = new Person("Tom", Gender.Male, LocalDate.of(1960, 04, 2));
        Person person4 = new Person("Emily", Gender.Female, LocalDate.of(1990, 8, 5));
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);


        // Добавляем отношения в дерево
        familyTree.addRelationship("John", "Tom");
        familyTree.addRelationship("Jane", "Tom");
        familyTree.addRelationship("John", "Emily");
        familyTree.addRelationship("Jane", "Emily");
        fh.save(familyTree);
        return familyTree;
    }

    public void addPerson(String name, Gender gender, LocalDate birthDate) {
        Person person = new Person(name, gender, birthDate);
        familyTree.addPerson(person);
    }

    public void displayFamilyTree() {
        for (FamilyTreeEntity person : familyTree) {
            displayPerson(person, 0);
        }
    }

    public void addRelationship(String parentName, String childName) {
        familyTree.addRelationship(parentName, childName);
    }

    public void displayPerson(FamilyTreeEntity person, int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  "); // отступ для каждого уровня
        }
        System.out.println(indentation + person.getName());
        for (FamilyTreeEntity child : person.getChildren()) {
            displayPerson(child, level + 1); // рекурсивно отображаем каждого ребенка
        }
    }
}
