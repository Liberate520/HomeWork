package ru.marat.geekbrains;

import ru.marat.geekbrains.models.FamilyTree;
import ru.marat.geekbrains.models.Person;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person john = new Person("John", 40);
        Person jane = new Person("Jane", 38);
        Person child1 = new Person("Child1", 18);
        Person child2 = new Person("Child2", 15);

        child1.setMother(jane);
        child1.setFather(john);
        child2.setMother(jane);
        child2.setFather(john);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(john);
        familyTree.addPerson(jane);
        familyTree.addPerson(child1);
        familyTree.addPerson(child2);

        List<Person> johnsChildren = familyTree.getChildren(john);
        System.out.println("Дети Джона:");
        for (Person child : johnsChildren) {
            System.out.println(child.getName());
        }
    }
}
