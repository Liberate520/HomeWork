package ru.gb2.family_tree7.model.group;

import ru.gb2.family_tree7.model.group.iterators.HumanIterator;
import ru.gb2.family_tree7.model.human.comparators.HumanComparatorByAge;
import ru.gb2.family_tree7.model.human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanGroup <E extends GroupItem> implements Iterable<E> {
    private List<E> humanList;

    public HumanGroup() {
        humanList = new ArrayList<>();
    }

    public void addHuman(E human){

        humanList.add(human);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByName());
    }
}