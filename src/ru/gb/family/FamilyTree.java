package ru.gb.family;

import ru.gb.vending.product.Product;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;


    public FamilyTree() {
        familyTree = new ArrayList<>();

        }
    public void addHumanInTree(Human newHuman){
        this.familyTree.add(newHuman);
    }

    public void findHuman (Human searchHuman){
        for (Human fd : this.familyTree ){
           if (fd.equals(searchHuman)){
               System.out.println("-----У человека ["+fd.getName()+"]  из семейного дерева-------------");
               if (fd.getChildren() != null){
                   System.out.println("Есть дети:");
                   StringBuilder stringBuilder = new StringBuilder();
                   // список детей
                   for (Human human : fd.getChildren()){
                       stringBuilder.append(human.getName());
                       stringBuilder.append(",\t");
                   }
                   System.out.println(stringBuilder);
               }
               else{
                   System.out.println("Нет детей!");
               }
               System.out.println("------------------------");
            }
        }

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
