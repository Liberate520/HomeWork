package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.human.HumanComparatorByAge;
import ru.gb.family_tree.model.human.HumanComparatorByName;
import ru.gb.family_tree.model.human.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyItem> implements Serializable, Iterable<E>, Tree {

    private List<E> familyTree;

    public FamilyTree(){
       familyTree = new ArrayList<>();
    }

    public void addHuman(E human){
        familyTree.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (E e: familyTree ){
           stringBuilder.append(e);
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge<>());
    }


}
