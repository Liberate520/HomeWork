package ru.gb.family;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();

        }
    public void addHumanInTree(Human newHuman){
        this.familyTree.add(newHuman);
    }

    public StringBuilder findHuman (Human searchHuman){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("-----У человека ["+searchHuman.getName()+"]  из семейного дерева-------------");
        stringBuilder.append("\n");
        for (Human fd : this.familyTree ){
           if (fd.equals(searchHuman)){
               if (fd.getChildren() != null){
                   stringBuilder.append("Есть дети:\n");

                   // список детей
                   for (Human human : fd.getChildren()){
                       stringBuilder.append(human.getName()+"("+human.getAge()+" лет.))");
                       stringBuilder.append("\t\n");

                   }

               }
               else{
                   stringBuilder.append("\nНет детей! ");
               }
               stringBuilder.append("----------------------------------------------");

            }
        }
        return stringBuilder;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список семейного Дерева:\n");
        for (Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
