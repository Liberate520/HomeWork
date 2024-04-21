package homeWork.human.humanComparator;

import java.util.Comparator;

import homeWork.familyTree.FamTree;

public class HumanComparatorByName<E extends FamTree> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
