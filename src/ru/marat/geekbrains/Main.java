package ru.marat.geekbrains;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;
import ru.marat.geekbrains.models.PersonRelationship;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", LocalDate.of(1983, 5, 10), "Male");
        Person jane = new Person("Jane", LocalDate.of(1985, 3, 15), "Female");
        Person child1 = new Person("Child1", LocalDate.of(2005, 6, 20), "Female");
        Person child2 = new Person("Child2", LocalDate.of(2008, 9, 5), "Male");

        child1.setMother(jane);
        child1.setFather(john);
        child2.setMother(jane);
        child2.setFather(john);

        FamilyTree<Person> familyTree = new FamilyTree<>(new PersonRelationship());
        familyTree.addMember(john);
        familyTree.addMember(jane);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        List<Person> johnsChildren = familyTree.getChildren(john);
        System.out.println("Дети Джона:");
        for (Person child : johnsChildren) {
            System.out.println(child.getName());
        }

        System.out.println("\nВсе люди в дереве:");
        System.out.println(familyTree);

        System.out.println("\nСортировка по имени:");
        familyTree.sortByName(Comparator.comparing(Person::getName));
        System.out.println(familyTree);

        System.out.println("\nСортировка по дате рождения:");
        familyTree.sortByBirthDate(Comparator.comparing(Person::getBirthDate));
        System.out.println(familyTree);
    }
}
