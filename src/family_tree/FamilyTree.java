package family_tree;

import java.io.Serializable;
import java.util.ArrayList;

import family_tree.iterators.TreeIterator;
import human.*;
import family_tree.comporators.TreeComparatorByBrithDate;
import family_tree.comporators.TreeComparatorByName;

import java.util.Iterator;
import java.util.List;
//import java.io.*;

public class FamilyTree<E extends TreeElement<E>> implements Serializable, Iterable<E> {
    private long idTree;
    private List<E> listHuman;
    public FamilyTree(List<E> listHuman){
        this.listHuman = listHuman;
    }
    public FamilyTree() {
        listHuman =new ArrayList<>();
        }
    public boolean  addHuman (E human){
        if (human == null) {return  false;}
        if (!listHuman.contains(human)){
            listHuman.add(human);
            human.setId(idTree++);
            addToParents(human);
            addToChildren(human);
            return true;
        }   return false;
    }

    private void  addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void  addToChildren(E human){
        for (E children: human.getChildren()){
            children.addChild(human);
        }
    }



    @Override
    public String toString() { return getInfo();};

public  String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Генеалогическое древо\n");
        for (E human: listHuman){
            sb.append(human);
            sb.append("\n");
            sb.append("\n");
            }
        return sb.toString();
    }
    public void sortByName(){
        listHuman.sort(new TreeComparatorByName());
    }

    public void sortByAge(){
        listHuman.sort(new TreeComparatorByBrithDate());
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator(listHuman);
    }



}
