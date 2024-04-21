package homeWork.human.humanComparator;

import java.util.Comparator;

import homeWork.familyTree.FamTree;
//import homeWork.human.Human;


public class HumanComparatorByDate<E extends FamTree> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2){
        return o1.getDob().compareTo(o2.getDob());
    }
}
