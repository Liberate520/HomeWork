package re.zip.famely_tree.srv;


import java.util.Comparator;
import re.zip.famely_tree.humans.Human;

public class HumanComparatorByFamelyName implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFamelyName().compareTo(o2.getFamelyName());
    }    

}