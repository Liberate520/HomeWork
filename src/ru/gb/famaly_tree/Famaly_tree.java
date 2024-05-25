package ru.gb.famaly_tree;

import java.util.*;

public class Famaly_tree {
    private String a;

    public void addThisInThis(Human child, Human parent){
        parent.children.add(child);
        child.mother = parent;
    }

    public void printFamalyTree(Human persona){
        Queue<Human> childrenList = new LinkedList<>();
        childrenList.add(persona);
        while (!childrenList.isEmpty()){
            Human child = childrenList.remove();
            System.out.println();
            System.out.print("У "+child.getName());
            if (!persona.children.isEmpty()){
                System.out.print(" дети: ");
                for (Human childchild : child.children){
                    System.out.print(childchild.getName()+ " ");
                    childrenList.add(childchild);
                }
            }
        }
    }



    public void printPersona(Human persona){
        System.out.println("имя: "+persona.getName());
        System.out.println("возраст: "+persona.Age());
        System.out.println("пол: "+persona.getGender());
        System.out.println("дата рождения: "+persona.getBirthDate());
        System.out.println("дата смерти: "+persona.getDeathDate());
        System.out.println("имя отца: "+persona.getFather());
        System.out.println("имя матери: "+persona.getMother());
        a="";
        if (!persona.getChildren().isEmpty()){
            for (Human child : persona.children){
                a += child.getName()+", ";
            }
        }
        else{
            a+="нет";
        }
        System.out.println("дети: "+a);
    }

    public void coupl(Human man, Human woman){
        man.children = woman.children;
        for(Human child : woman.children){
            child.father = man;
        }
    }
}