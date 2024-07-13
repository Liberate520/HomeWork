package com.familytree.view;

import com.familytree.model.Human;

import java.util.List;

public class FamilyTreeViewImpl implements FamilyTreeView {

    @Override
    public void showChildren(List<Human> children) {
        System.out.println("Children:");
        for (Human child : children) {
            System.out.println(child);
        }
    }

    @Override
    public void showPeopleSortedByName(List<Human> people) {
        System.out.println("\nPeople sorted by name:");
        for (Human person : people) {
            System.out.println(person);
        }
    }

    @Override
    public void showPeopleSortedByBirthDate(List<Human> people) {
        System.out.println("\nPeople sorted by birth date:");
        for (Human person : people) {
            System.out.println(person);
        }
    }
}
