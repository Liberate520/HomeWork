package oop_home.my_familyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private String name;


    private ArrayList<Human> humanList = new ArrayList<>();

    // Список людей

    public FamilyTree(String name) {
        this.name = name;
    }

    public String printFamilyTree() {
        StringBuilder sb = new StringBuilder();
        for (Human h : humanList) {
            sb.append(h + "\n");
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree("Семейное древо Сергея");
        Human human1 = new Human("Кокшаров", "Сергей","Александрович", 34, "Мужской");
        Human human2 = new Human("Кокшарова", "Дарья","Александровна", 23, "Женский");
        Human parent1 = new Human("Кокшаров", "Александр","Александрович", 51, "Мужской");
        Human parent2 = new Human("Кокшарова", "Наталья","Петровна", 51, "Женский");
        familyTree.humanList.add(human1);
        familyTree.humanList.add(human2);
        familyTree.humanList.add(parent1);
        familyTree.humanList.add(parent2);
        //System.out.println(familyTree.humanList.get(0));
        System.out.println(familyTree.printFamilyTree());

        
    
    }
}
