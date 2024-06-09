package com.familytree.view;

import com.familytree.model.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreeView {
    private List<Human> humans;

    public FamilyTreeView(List<Human> humans) {
        this.humans = humans;
    }

    public void updateView(){
        System.out.println("Список людей обновлен!");
    }

    public void displayHumans() {
        for (Human human : humans) {
            System.out.println(human.getName());
        }
    }
}
