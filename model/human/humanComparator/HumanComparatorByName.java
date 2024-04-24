package homeWork.model.human.humanComparator;

import java.util.Comparator;

import homeWork.model.familyTree.FamTree;

public class HumanComparatorByName<E extends FamTree> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
