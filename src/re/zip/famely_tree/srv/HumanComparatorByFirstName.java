package re.zip.famely_tree.srv;

import re.zip.famely_tree.humans.Human;
import java.util.Comparator;

public class HumanComparatorByFirstName implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }    

}