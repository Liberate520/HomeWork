package human.comparator;

import human.Human;
import tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorById<T extends TreeItem>  implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare((int)o1.getId(), (int)o2.getId());
    }

}