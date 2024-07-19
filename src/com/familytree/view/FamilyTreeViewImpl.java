package com.familytree.view;

import com.familytree.model.Human;

import java.util.List;

public class FamilyTreeViewImpl implements FamilyTreeView {

    @Override
    public void showPeople(List<Human> people) {
        if (people.isEmpty()) {
            System.out.println("No people found.");
        } else {
            for (Human person : people) {
                System.out.println(person);
            }
        }
    }

    @Override
    public void showError(String message) {
        System.out.println("Error: " + message);
    }
}
