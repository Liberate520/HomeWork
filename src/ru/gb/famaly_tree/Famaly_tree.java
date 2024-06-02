package ru.gb.famaly_tree;

import java.io.Serializable;
import java.util.*;

public class Famaly_tree implements Serializable {
    private String childStringOutput;       // надо переименовать +
    public Human founder;

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

    public void Founder(Human founderOfFamalyTree){
        founder = founderOfFamalyTree;

    }


    public void printPersona(Human persona){
        System.out.println("имя: "+persona.getName());
        System.out.println("возраст: "+persona.Age());
        System.out.println("пол: "+persona.getGender());
        System.out.println("дата рождения: "+persona.getBirthDate());
        System.out.println("дата смерти: "+persona.getDeathDate());
        System.out.println("имя отца: "+persona.getFather());
        System.out.println("имя матери: "+persona.getMother());
        childStringOutput ="";
        if (!persona.getChildren().isEmpty()){
            for (Human child : persona.children){
                childStringOutput += child.getName()+", ";
            }
        }
        else{
            childStringOutput +="нет";
        }
        System.out.println("дети: "+ childStringOutput);
    }

    public void coupl(Human man, Human woman){
        man.children = woman.children;
        for(Human child : woman.children){
            child.father = man;
        }
    }
}