package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.HumanComparatorByAge;
import ru.gb.family_tree.human.HumanComparatorByName;
import ru.gb.family_tree.human.HumanComparatorByNumberOfChild;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> tree;

    public FamilyTree(){
        tree = new ArrayList<>();
    }

    public void addHuman(Human human){
        tree.add(human);
    }
    //поиск любого упоминания имени человека
    public List<Human> findHuman(String name){
        List<Human> list = new ArrayList<>();
        for (Human human: tree){
            if (human.toString().contains(name)){
                list.add(human);
            }
        }
        return list;
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

    public void sortByName(){
        tree.sort(new HumanComparatorByName());
    }
    public void sortByAge(){
        tree.sort(new HumanComparatorByAge());
    }
    public void sortByChild(){
        tree.sort(new HumanComparatorByNumberOfChild());
    }
    @Override
    public Iterator<Human> iterator() {
        return new FTiterator(tree);
    }
}
