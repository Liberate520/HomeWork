package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> tree;

    public FamilyTree(){
        tree = new ArrayList<>();
    }

    public void addHuman(Human human){
        tree.add(human);
    }
    //поиск любого упоминания имени человека
    public String findHuman(String name){
        StringBuilder sb = new StringBuilder();
        sb.append("Результат поиска:\n");
        for (Human human: tree){
            if (human.toString().contains(name)){
                sb.append(human + "\n");
            }
        }
        return sb.toString();
    }

    public String getFullTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("Древо: \n");
        for (Human human: tree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
