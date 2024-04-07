package family_tree;

import java.io.Serializable;
import java.util.ArrayList;

import human.*;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

import java.util.Iterator;
import java.util.List;
//import java.io.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long idTree;
    private List<Human> listHuman;
    public FamilyTree(List<Human> listHuman){
        this.listHuman = listHuman;
    }
    public FamilyTree() {
        listHuman =new ArrayList<>();
        }
    public boolean  addHuman (Human human){
        if (human == null) {return  false;}
        if (!listHuman.contains(human)){
            listHuman.add(human);
            human.setId(idTree++);
            addToParents(human);
            addToChildren(human);
            return true;
        }   return false;
    }

    private void  addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void  addToChildren(Human human){
        for (Human parent: human.getChildren()){
            parent.addParents(human);
        }
    }



    @Override
    public String toString() { return getInfo();};

public  String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Генеалогическое древо\n");
        for (Human human: listHuman){
            sb.append(human);
            sb.append("\n");
            sb.append("\n");
            }
        return sb.toString();
    }
    public void sortByName(){
        listHuman.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        listHuman.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(listHuman);
    }



}
