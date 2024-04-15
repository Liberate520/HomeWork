package homeWork.human.humanComparator;

import java.util.Comparator;
import homeWork.human.Human;


public class HumanComparatorByDate implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2){
        return o1.getDob().compareTo(o2.getDob());
    }
}
