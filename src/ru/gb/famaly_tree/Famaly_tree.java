package ru.gb.famaly_tree;

import java.io.Serializable;
import java.util.*;

public class Famaly_tree implements Serializable {
    private Human founder;

    public void addThisInThis(Human child, Human parent){
        parent.addChild(child);
        if (parent.getGender() == Gender.male){
            child.addFather(parent);
        }
        else{
            child.addMother(parent);
        }
    }

    public void printFamalyTree(Human persona){
        Queue<Human> childrenList = new LinkedList<>();
        childrenList.add(persona);
        while (!childrenList.isEmpty()){
            Human child = childrenList.remove();
            System.out.println();
            System.out.print("У "+child.getName());
            if (!persona.getChildren().isEmpty()){
                System.out.print(" дети: ");
                for (Human childchild : child.getChildren()){
                    System.out.print(childchild.getName()+ " ");
                    childrenList.add(childchild);
                }
            }
        }
    }

    public void AddFounder(Human founderOfFamalyTree){
        founder = founderOfFamalyTree;
    }
    public Human GetFounder(){
        return founder;
    }

    public void coupl(Human man, Human woman){
        man.addChildren(woman.getChildren());
        for(Human child : woman.getChildren()){
            child.addFather(man);
        }
    }
}