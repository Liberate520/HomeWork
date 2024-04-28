package re.zip.famely_tree.srv;

import java.util.Comparator;

public class FamelyTreeElementComparatorByFamelyName<T extends FamelyTreeElement<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.getFamelyName().compareTo(o2.getFamelyName());
    }    

}