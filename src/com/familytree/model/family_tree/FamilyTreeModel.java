package com.familytree.model.family_tree;

import com.familytree.model.human.Human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeModel {
    private static List<Human> humans;

    public FamilyTreeModel() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(Human human){
        humans.add(human);
    }

    public static List<Human>getHumans(){return humans;}


    public void sortByName(){
        Collections.sort(humans, Comparator.comparing(Human::getName));
        List<Human> humans = FamilyTreeModel.getHumans();
        Collections.sort(humans, new Comparator<>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println("Отсортированный список по имени:");
        for (Human human : humans) {
            System.out.println(human.getName());
        }
    }

    public void sortByBirthDate() {
        List<Human> humans = FamilyTreeModel.getHumans();
        Collections.sort(humans, new Comparator<>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getBirthDate().compareTo(o2.getBirthDate());
            }
        });
        System.out.println("Отсортированный список по дате рождения:");
        for (Human human : humans) {
            System.out.println(human.getBirthDate());
        }
    }


}
