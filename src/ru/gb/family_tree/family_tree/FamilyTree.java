package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.HumanComparatorByAge;
import ru.gb.family_tree.service.HumanComparatorByName;
import ru.gb.family_tree.service.HumanIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {

    private List<Human> familyTree;

    public FamilyTree(){
       familyTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        familyTree.add(human);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(familyTree);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: familyTree ){
           stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge());
    }


}
