package com.example.familytree.mvp;

import com.example.familytree.model.Person;

import java.util.List;
import java.util.Scanner;

public class ConsoleFamilyTreeView extends FamilyTreeView {
    public ConsoleFamilyTreeView() {
        super();
    }

    @Override
    public void displayTree(List<Person> members) {
        for (Person person : members) {
            System.out.println(person);
            List<Person> children = person.getChildren();
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (Person child : children) {
                    System.out.println("  - " + child);
                }
            }
        }
    }
}
